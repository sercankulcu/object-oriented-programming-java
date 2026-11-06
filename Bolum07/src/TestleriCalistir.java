import java.util.ArrayList;
import java.util.List;

import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

// Bolumdeki butun JUnit 5 test siniflarini JUnit Platform Launcher API ile calistirir,
// her testin sonucunu ve sonunda ozeti yazar. Bilerek kalan testler vardir;
// program yine 0 ile cikar.
public class TestleriCalistir {

	// Sunumdaki butun test siniflari (slayt sirasiyla)
	static final Class<?>[] TEST_SINIFLARI = {
		HesapMakinesiTest.class, AaaTest.class, BankaHesabiTest.class,
		BankaIstisnaTest.class, YasamDongusuTest.class, DiziIslemTest.class,
		NotTest.class, TestAdlariTest.class, ZarTest.class, IsaretTest.class,
		OzellikTest.class, OzellikTest2.class, SoruTest.class, SayacTest.class
	};

	// Verilen test siniflarini calistirir, sonuclari ve ozeti yazar
	public static TestExecutionSummary calistir(Class<?>... siniflar) {
		List<DiscoverySelector> secimler = new ArrayList<>();
		for (Class<?> sinif : siniflar) {
			secimler.add(selectClass(sinif));
		}
		LauncherDiscoveryRequest istek = LauncherDiscoveryRequestBuilder.request()
				.selectors(secimler).build();
		Launcher launcher = LauncherFactory.create();
		SummaryGeneratingListener ozet = new SummaryGeneratingListener();
		launcher.execute(istek, ozet, new SonucYazici());

		TestExecutionSummary s = ozet.getSummary();
		System.out.println("---- Ozet ----");
		System.out.println("Bulunan test : " + s.getTestsFoundCount());
		System.out.println("Gecen        : " + s.getTestsSucceededCount());
		System.out.println("Kalan        : " + s.getTestsFailedCount());
		for (TestExecutionSummary.Failure h : s.getFailures()) {
			System.out.println("  KALDI: " + h.getTestIdentifier().getDisplayName()
					+ " -> " + h.getException().getMessage());
		}
		return s;
	}

	// Her test bitince "[GECTI]" ya da "[KALDI]" satiri yazar
	static class SonucYazici implements TestExecutionListener {
		private TestPlan plan;

		@Override
		public void testPlanExecutionStarted(TestPlan plan) {
			this.plan = plan;
		}

		@Override
		public void executionFinished(TestIdentifier id, TestExecutionResult sonuc) {
			if (!id.isTest()) {
				return;
			}
			String ust = plan.getParent(id).map(TestIdentifier::getDisplayName).orElse("");
			boolean gecti = sonuc.getStatus() == TestExecutionResult.Status.SUCCESSFUL;
			System.out.println((gecti ? "[GECTI] " : "[KALDI] ") + ust + " > " + id.getDisplayName());
		}
	}

	public static void main(String[] args) {
		calistir(TEST_SINIFLARI);
		// Bilerek kalan testler: BankaIstisnaTest.yanlisBeklenti, DiziIslemTest.tumuNegatifDizi,
		// OzellikTest2, SoruTest.b, SoruTest.d ve SayacTest.ikiKezArtir.
		// Ozet: Bulunan test : 35, Gecen : 29, Kalan : 6
	}
}

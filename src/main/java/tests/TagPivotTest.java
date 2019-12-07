/**
 * 
 */
package tests;

import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class TagPivotTest extends TestRoot {
	private final String TID = "adra2b";

	/**
	 * 
	 */
	public TagPivotTest() {
		IResult r = pivotSuite.listPivotsByTag(TID, 0, 20);
	    System.out.println("A "+r.getResultObject());
		environment.shutDown();
		System.exit(0);
	}

}
/*
{
	"documents": [{
		"docId": "EIB8cC1bEema_J_wDmrnOQ",
		"text": ["These are genetic variants we need to catalog.", "To identify genetic variants that could intensify or attenuate the response, we assessed the relation between response and candidate genotypes in subjects who had been assigned to the capsinoid group. The following 13 genetic polymorphisms were selected from the National Center for Biotechnology Information database on the basis of biological plausibility and an anticipated minor allele frequency of >10% in the studied population: TRPV1 [transient receptor potential cation channel, subfamily V, member 1; also known as vanilloid receptor 1 (VR1) or capsaicin receptor] Val585Ile, Met315Ile, Thr469Ile; PPARG (peroxisome proliferator-activated receptor-γ) Pro12Ala; UCP1 (uncoupling protein 1) −3826 A\/G, Leu229Met; UCP2 (uncoupling protein 2) −866 G\/A, UCP3 (uncoupling protein 3) −55 C\/T, ADRB1 (β1-adrenergic receptor) Arg389Gly; ADRB2 (β2-adrenergic receptor) Arg16Gly, Gln27Glu; ADRB3 (β3-adrenergic receptor) Trp64Arg; and ADRA2B (α2b-adrenergic receptor) Glu9\/Glu12 insertion\/deletion. The 5\u2032 nuclease-based assay (TaqMan; Applied Biosystems, Foster City, CA) was used to genotype single nucleotide polymorphisms, and pyrosequencing was used for the insertion-deletion variant."],
		"title": "Effects of novel capsinoid treatment on fatness and energy metabolism in humans: possible pharmacogenetic implications",
		"url": "https:\/\/www.ncbi.nlm.nih.gov\/pmc\/articles\/PMC3151435\/"
	}],
	"groups": [{
		"tagId": "6xkx19i3",
		"name": "biomed"
	}],
	"label": "ADRA2B",
	"users": ["Gardener@hypothes.is"]
}
*/
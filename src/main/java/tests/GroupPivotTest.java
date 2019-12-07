/**
 * 
 */
package tests;

import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class GroupPivotTest extends TestRoot {
	private final String GID = "6xkx19i3";

	/**
	 * 
	 */
	public GroupPivotTest() {
		IResult r = pivotSuite.listPivotsByGroup(GID, 0, 10);
	    System.out.println("A "+r.getResultObject());
		environment.shutDown();
		System.exit(0);
	}

}
/*
{
"documents": [{
	"docId": "klZsGCGVEemSQq-EVLvgXA",
	"text": ["Brown fat keeps blood sugar in check", "Paul Lee in the youtube https:\/\/www.youtube.com\/watch?v=GCBL2N2pmeY search results on this page"],
	"title": "%%title%% | Garvan Institute of Medical Research",
	"url": "https:\/\/www.garvan.org.au\/"
}, {
	"docId": "m9OHuEgOEemXlounhz5Phw",
	"text": ["A growing body of evidence supports the concept that Alzheimer\u2019s Disease (AD) is a metabolic disease that results from impaired insulin signaling, insulin resistance, and low levels of insulin in the brain.  Because the molecular and biochemical consequences of impaired insulin signaling are shared with Type I and Type 2 diabetes, the term \u201CType 3 diabetes\u201D has been suggested for AD.  There is also evidence that people who have Type 2 diabetes have a heightened risk of developing AD.  Understanding the possible associations between Type 2 diabetes and AD may lead to effective early diagnosis and treatment of AD.  It may also help to identify patients with Type 2 diabetes who are at high risk for developing AD.  In this article, we examine the possible associations between Type 2 diabetes and AD. ", "The information contained in this article will enhance student comprehension of the neuroendocrine system and their appreciation for the current research associated with a possible link between Alzheimer\u2019s Disease and Diabetes, associated with the pedagogy of courses in Human Anatomy and Physiology, Human Physiology, Advanced Physiology and Neurobiology. IntroductionThe first indication that patients with Type 2 diabetes mellitus (T2DM) have an increased risk of developing Alzheimer\u2019s Disease (AD) appeared in the Rotterdam study (Dar et al. 2014), a prospective study that has been ongoing since 1990 in Rotterdam, The Netherlands (Ikram et al. 2017).  Participants in the Rotterdam study, who currently number 14,926 individuals over the age of 40, are monitored for a variety of diseases that are known to affect the elderly, among them: heart disease, stroke, AD, Parkinson\u2019s disease, diabetes, and osteoporosis.  The Honolulu-Asia Aging Study, initiated in 1990 to study abnormalities associated with dementia in 3734 Japanese-American men and closed in 2012 (Gelber etal. 2012), similarly found a strong association between T2DM and AD (Peila et al.2002).  The number of people who suffer from these diseases is staggering. Conservative estimates put the number of people with AD at 36 million worldwide and that number is expected to double every twenty years until 2040 (Narasimhan 2014).  The number of people who suffer from diabetes may exceed 347 million worldwide (Yang and Song 2013).  Diabetes mellitus is associated with the subsequent development of AD in the aging population (Dar et al. 2014) and people with T2DM are believed to be 50-65% more likely to develop AD as they age compared to people who are not diabetic (Dar et al. 2014, http:\/\/dlife.com\/type-3-diabetes, www.diabetes.co.uk\/type3-diabetes.html).  There is currently a debate about the degree to which T2DM and perhaps T1DM contribute to the pathogenesis of AD that centers on the rising prevalence of obesity, T2DM and AD over the past 20 years.  Some degree of association between diabetes and AD is suggested by the following (de la Monte and Wands 2008):1.  An increased risk for developing mild cognitiveimpairment (MCI), dementia, or AD in patients who havebeen diagnosed with T2DM.2.  The presence of progressive insulin resistance (IR) andinsulin deficiency that has been observed in the brain ofAlzheimer\u2019s patients.3.  Observations of cognitive impairment in animal modelsof T2DM and obesity.4.  Neurodegeneration and cognitive impairment in animalmodels where IR or insulin deficiency have been induced.5.  Observations of improved cognitive performance inexperimental animals who have received intranasalinsulin treatment for cognitive impairment.6.  The presence of several biochemical and molecularabnormalities that are shared in T2DM and AD.(de la Monte and Wands 2008)continued on next page\n"],
	"title": "(18) (PDF) The Case for Alzheimer\u2019s Disease as Type 3 Diabetes",
	"url": "https:\/\/www.researchgate.net\/publication\/326699884_The_Case_for_Alzheimer's_Disease_as_Type_3_Diabetes"
}, {
	"docId": "_MCe2h88EemfxyMDElTjmw",
	"text": ["This paper explores the underlying information system of Chinese Feng Shui, translated literally as \"wind and water,\" and compares and contrasts it with theories of complexity science, quantum mechanics, and systems science.", "Traditional Chinese Medicine -- an important thread"],
	"title": "(21) (PDF) Wind and water: Feng Shui as complexity science",
	"url": "https:\/\/www.researchgate.net\/publication\/330554330_Wind_and_water_Feng_Shui_as_complexity_science"
}, {
	"docId": "QrqcPCSsEemgH6MwvwvvSA",
	"text": ["Studying the IoF framework. Relation to nutrition K-Hub.", "To\t\r  construct\t\r  a\t\r  framework\t\r  to\t\r  be\t\r  used\t\r  for\t\r  structuring\t\r  the\t\r  discussion\t\r  around\t\r  Internet\t\r  and\t\r  food,\t\r  thereby\t\r  furthering\t\r  the\t\r  discussion\t\r  around\t\r  how\t\r  to\t\r  facilitate\t\r  openness\t\r  and\t\r  innovaLon\t\r  in\t\r  the\t\r  field\t\r  of\t\r  food\t\r  with\t\r  the\t\r  goal\t\r  to\t\r  feed\t\r  the\t\r  planet\t\r  in\t\r  a\t\r  healthy\t\r  and\t\r  sustainable\t\r  way\t\r "],
	"title": "20150425-IoF_Framework-Basic.pdf",
	"url": "http:\/\/internet-of-food.org\/files\/2015\/08\/20150425-IoF_Framework-Basic.pdf"
}, {
	"docId": "5vtTSFlHEemxDcNPX_Fqmg",
	"text": ["Pharmacological agents that raise cAMP and activate protein kinase A (PKA) stimulate 26S proteasome activity, phosphorylation of subunit Rpn6, and intracellular degradation of misfolded proteins. We investigated whether a similar proteasome activation occurs in response to hormones and under various physiological conditions that raise cAMP. Treatment of mouse hepatocytes with glucagon, epinephrine, or forskolin stimulated Rpn6 phosphorylation and the 26S proteasomes\u2019 capacity to degrade ubiquitinated proteins and peptides. These agents promoted the selective degradation of short-lived proteins, which are misfolded and regulatory proteins, but not the bulk of cell proteins or lysosomal proteolysis. Proteasome activities and Rpn6 phosphorylation increased similarly in working hearts upon epinephrine treatment, in skeletal muscles of exercising humans, and in electrically stimulated rat muscles. In WT mouse kidney cells, but not in cells lacking PKA, treatment with antidiuretic hormone (vasopressin) stimulated within 5-minutes proteasomal activity, Rpn6 phosphorylation, and the selective degradation of short-lived cell proteins. In livers and muscles of mice fasted for 12\u201348 hours cAMP levels, Rpn6 phosphorylation, and proteasomal activities increased without any change in proteasomal content. Thus, in vivo cAMP-PKA\u2013mediated proteasome activation is a common cellular response to diverse endocrine stimuli and rapidly enhances the capacity of target tissues to degrade regulatory and misfolded proteins (e.g., proteins damaged upon exercise). The increased destruction of preexistent regulatory proteins may help cells adapt their protein composition to new physiological conditions."],
	"title": "26S Proteasomes are rapidly activated by diverse hormones and physiological states that raise cAMP and cause Rpn6 phosphorylation",
	"url": "https:\/\/www.pnas.org\/content\/116\/10\/4228"
}, {
	"docId": "lMxucllHEemP7gfh2WbSSQ",
	"text": ["Most studies of proteolysis by the ubiquitin-proteasome pathway have focused on the regulation by ubiquitination. However, we showed that pharmacological agents that raise cAMP and activate protein kinase A by phosphorylating a proteasome subunit enhance proteasome activity and the cell\u2019s capacity to selectively degrade misfolded and regulatory proteins. We investigated whether similar adaptations occur in physiological conditions where cAMP rises. Proteasome activity increases by this mechanism in human muscles following intense exercise, in mouse muscles and liver after a brief fast, in hepatocytes after epinephrine or glucagon, and renal collecting duct cells within 5 minutes of antidiuretic hormone. Thus, hormones and conditions that raise cAMP rapidly enhance proteasome activity and the cells\u2019 capacity to eliminate damaged and preexistent regulatory proteins."],
	"title": "26S Proteasomes are rapidly activated by diverse hormones and physiological states that raise cAMP and cause Rpn6 phosphorylation",
	"url": "https:\/\/www.pnas.org\/content\/116\/10\/4228"
}],
"name": "biomed",
"users": ["Gardener@hypothes.is"],
"tags": [{
	"label": "10000 Steps",
	"id": "10000_steps"
}, {
	"label": "26S Proteasome Activity",
	"id": "26s_proteasome_activity"
}, {
	"label": "4400 Steps",
	"id": "4400_steps"
}, {
	"label": "5-8Hz",
	"id": "5-8hz"
}, {
	"label": "5-HT",
	"id": "5-ht"
}, {
	"label": "5-hydroxytryptamine",
	"id": "5-hydroxytryptamine"
}, {
	"label": "72 KDa Type IV Collagenase",
	"id": "72_kda_type_iv_collagenase"
}, {
	"label": "7500 Steps",
	"id": "7500_steps"
}, {
	"label": "ABB",
	"id": "abb"
}, {
	"label": "AD",
	"id": "ad"
}]
}
*/
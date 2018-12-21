/**
 * 
 */
package tests;

import org.apache.http.HttpEntity;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class FirstClientTest extends TestRoot {
	/**
	 * 
	 */
	public FirstClientTest() {
		IResult r = client.loadAnnotations();
		System.out.println("A "+r.getErrorString());
		System.out.println("B "+r.getResultObject());
		environment.shutDown();
		System.exit(0);
	}

}
/**
{
	"rows": [{
		"updated": "2018-12-15T16:16:12.225402+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://medicalxpress.com/news/2018-12-magnesium-optimizes-vitamin-d-status.html",
			"selector": [{
				"endContainer": "/article[1]/div[1]/p[3]",
				"startContainer": "/article[1]/div[1]/p[3]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 426
			}, {
				"type": "TextPositionSelector",
				"end": 3376,
				"start": 2950
			}, {
				"exact": "The study reported in the December issue of The American Journal of Clinical Nutrition is important because of controversial findings from ongoing research into the association of vitamin D levels with colorectal cancer and other diseases, including a recent report from the VITAL trial. It gave confirmation to a prior observational study in 2013 by the researchers that linked low magnesium levels with low vitamin D levels.",
				"prefix": "3098146&avms=ampa\"}}\n\t\t\t\t\t\n\t\n\t\t\t",
				"type": "TextQuoteSelector",
				"suffix": "\nThe trial also revealed somethi"
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/vU6pMACEEem9PdtjGwIgQw",
			"html": "https://hypothes.is/a/vU6pMACEEem9PdtjGwIgQw",
			"incontext": "https://hyp.is/vU6pMACEEem9PdtjGwIgQw/medicalxpress.com/news/2018-12-magnesium-optimizes-vitamin-d-status.html"
		},
		"tags": ["Magnesium", "Vitamin D"],
		"text": "",
		"created": "2018-12-15T16:16:12.225402+00:00",
		"uri": "https://medicalxpress.com/news/2018-12-magnesium-optimizes-vitamin-d-status.html",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["Study shows magnesium optimizes vitamin D status"]
		},
		"id": "vU6pMACEEem9PdtjGwIgQw",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-12-15T16:14:55.793191+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://www.researchgate.net/publication/324163280_Intakes_of_magnesium_calcium_and_risk_of_fatty_liver_disease_and_prediabetes",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "rgw4_5c1527d9c28f9"
			}, {
				"endContainer": "/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]",
				"startContainer": "/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 1486
			}, {
				"type": "TextPositionSelector",
				"end": 2561,
				"start": 1075
			}, {
				"exact": "Objective\nObesity and insulin resistance play important roles in the pathogenesis of non-alcoholic fatty liver disease (NAFLD). Mg intake is linked to a reduced risk of metabolic syndrome and insulin resistance; people with NAFLD or alcoholic liver disease are at high risk of Mg deficiency. The present study aimed to investigate whether Mg and Ca intakes were associated with risk of fatty liver disease and prediabetes by alcohol drinking status.\n\nDesign\nWe analysed the association between Ca or Mg intake and fatty liver disease, prediabetes or both prediabetes and fatty liver disease in cross-sectional analyses.\n\nSetting\nThird National Health and Nutrition Examination Survey (NHANES III) follow-up cohort of US adults.\n\nSubjects\nNationally representative sample of US adults in NHANES ( n 13 489).\n\nResults\nAfter adjusting for potential confounders, Mg intake was associated with approximately 30 % reduced odds of fatty liver disease and prediabetes, comparing the highest intake quartile v . the lowest. Mg intake may only be related to reduced odds of fatty liver disease and prediabetes in those whose Ca intake is less than 1200 mg/d. Mg intake may also only be associated with reduced odds of fatty liver disease among alcohol drinkers.\n\nConclusions\nThe study suggests that high intake of Mg may be associated with reduced risks of fatty liver disease and prediabetes. Further large studies, particularly prospective cohort studies, are warranted to confirm the findings.",
				"prefix": "rticle with your peersAdAbstract",
				"type": "TextQuoteSelector",
				"suffix": "\u2026\u00a0Read morePublic Full-texts Hig"
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/kAXspACEEemkPRO4kC496A",
			"html": "https://hypothes.is/a/kAXspACEEemkPRO4kC496A",
			"incontext": "https://hyp.is/kAXspACEEemkPRO4kC496A/www.researchgate.net/publication/324163280_Intakes_of_magnesium_calcium_and_risk_of_fatty_liver_disease_and_prediabetes"
		},
		"tags": ["Obesity", "NAFLD", "Non-alcoholic Fatty Liver Disease", "Magnesium", "Mg", "Metabolic Syndrome", "Insulin Resistence", "Calcium", "Ca"],
		"text": "",
		"created": "2018-12-15T16:14:55.793191+00:00",
		"uri": "https://www.researchgate.net/publication/324163280_Intakes_of_magnesium_calcium_and_risk_of_fatty_liver_disease_and_prediabetes",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["(19) Intakes of magnesium, calcium and risk of fatty liver disease and prediabetes | Request PDF"]
		},
		"id": "kAXspACEEemkPRO4kC496A",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-12-04T17:21:32.058430+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://www.biorxiv.org/content/early/2018/12/04/484170",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "p-2"
			}, {
				"endContainer": "/div[3]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]",
				"startContainer": "/div[3]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 1218
			}, {
				"type": "TextPositionSelector",
				"end": 4511,
				"start": 3293
			}, {
				"exact": "Hematopoiesis is a dynamic process involving the up- and down-regulation of genes, as well as feed-back loops that stimulate or suppress circulating cytokine concentrations. More complete pictures of the gene regulatory networks that control the production of the blood system have emerged with the advent of single-cell sequencing techniques and refinements to the capabilities of immunoassays. However, information about the regulatory networks of cytokines is still lacking. A novel mathematical technique (convergent cross-mapping, or CCM) allows for the extraction of causal relationships from data, which is of crucial importance for understanding these networks. To reconstruct the cytokine networks within the hematopoietic system we measured the concentrations of 62 cytokines, platelets, and thrombopoietin from an individual with cyclic thrombocytopenia (regular oscillations in the megakaryocytes and platelets) over 84 days. Using CCM, we identified 61 previously unreported cytokine relationships. Our approach is the first broad-scale investigation into causal relationships between cytokines in the blood and suggests a new paradigm for understanding how dynamic regulation occurs during hematopoiesis.",
				"prefix": "   \n  \n      \n  \n  \n    Abstract",
				"type": "TextQuoteSelector",
				"suffix": "  \n\n  \n  \n\n  \n      \n  \n  \n    C"
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/C4MmKvfpEeirBW_lLefr1g",
			"html": "https://hypothes.is/a/C4MmKvfpEeirBW_lLefr1g",
			"incontext": "https://hyp.is/C4MmKvfpEeirBW_lLefr1g/www.biorxiv.org/content/early/2018/12/04/484170"
		},
		"tags": ["Hematopoiesis", "Up-Regulation", "Down-Regulation", "Genes", "Cytokine Concentrations", "Cytokine Networks", "Platlets", "Cytokines", "Thrombopoietin"],
		"text": "",
		"created": "2018-12-04T17:21:32.058430+00:00",
		"uri": "https://www.biorxiv.org/content/early/2018/12/04/484170",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["Novel cytokine interactions identified during perturbed hematopoiesis"]
		},
		"id": "C4MmKvfpEeirBW_lLefr1g",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-12-04T17:15:16.412688+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://www.cell.com/immunity/fulltext/S1074-7613(18)30478-3",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "pb-page-content"
			}, {
				"endContainer": "/div[3]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[2]/div[3]/div[1]/div[2]/section[2]/div[1]/div[1]",
				"startContainer": "/div[3]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[2]/div[3]/div[1]/div[2]/section[2]/div[1]/div[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 1066
			}, {
				"type": "TextPositionSelector",
				"end": 30543,
				"start": 29477
			}, {
				"exact": "Nutritional supplementation with probiotics can prevent pathologic bone loss. Here we examined the impact of supplementation with Lactobacillus rhamnosus GG (LGG) on bone homeostasis in eugonadic young mice. Micro-computed tomography revealed that LGG increased trabecular bone volume in mice, which was due to increased bone formation. Butyrate produced in the gut following LGG ingestion, or butyrate fed directly to germ-free mice, induced the expansion of intestinal and bone marrow (BM) regulatory T (Treg) cells. Interaction of BM CD8+ T\u00a0cells with Treg cells resulted in increased secretion of Wnt10b, a bone anabolic Wnt ligand. Mechanistically, Treg cells promoted the assembly of a NFAT1-SMAD3 transcription complex in CD8+ cells, which drove expression of Wnt10b. Reducing Treg cell numbers, or reconstitution of TCR\u03b2\u2212/\u2212 mice with CD8+ T\u00a0cells from Wnt10b\u2212/\u2212 mice, prevented butyrate-induced bone formation and bone mass acquisition. Thus, butyrate concentrations regulate bone anabolism via Treg cell-mediated regulation of CD8+ T cell Wnt10b production.",
				"prefix": " signaling in osteoblastsSummary",
				"type": "TextQuoteSelector",
				"suffix": "Graphical AbstractGraphical Abst"
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/K2q2yvfoEeiJCjtF97hltg",
			"html": "https://hypothes.is/a/K2q2yvfoEeiJCjtF97hltg",
			"incontext": "https://hyp.is/K2q2yvfoEeiJCjtF97hltg/www.cell.com/immunity/fulltext/S1074-7613(18)30478-3"
		},
		"tags": ["Probiotics", "Bone Loss", "Lactobacillus Rhamnosus GG", "LGG", "Bone Homeostasis", "Butyrate", "Bone Marrow", "Treg Cell", "Bone Anabolism"],
		"text": "",
		"created": "2018-12-04T17:15:16.412688+00:00",
		"uri": "https://www.cell.com/immunity/fulltext/S1074-7613(18)30478-3",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["The Microbial Metabolite Butyrate Stimulates Bone Formation via T Regulatory Cell-Mediated Regulation of WNT10B Expression"]
		},
		"id": "K2q2yvfoEeiJCjtF97hltg",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-11-30T20:32:58.931424+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://www.biorxiv.org/content/early/2018/11/30/482760",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "p-2"
			}, {
				"endContainer": "/div[3]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]",
				"startContainer": "/div[3]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 1932
			}, {
				"type": "TextPositionSelector",
				"end": 5259,
				"start": 3327
			}, {
				"exact": "Actual causes of Parkinson's disease (PD) are still unknown. In any case, a better comprehension of genetic and ecological influences to the PD and their interaction will assist physicians and patients to evaluate individual hazard for the PD, and definitely, there will be a possibility to find a way to reduce the progression of the PD. We introduced quantitative frameworks to reveal the complex relationship of various biasing genetic factors for the PD. In this study, we analyzed gene expression microarray data from the PD, ageing (AG), severe alcohol consumption (AC), type II diabetes (T2D), high body fat (HBF), hypercholesterolemia (HC), high dietary fat (HDF), red meat dietary (RMD), sedentary lifestyle (SL), smoking (SM), and control datasets. We have developed genetic associations of various factors with the PD based on the neighbourhood-based benchmarking and multilayer network topology. We identified 1343 significantly dysregulated genes in the PD patients compared to the healthy control, where we have 779 genes down-regulated and 544 genes up-regulated. 69 genes were highly expressed in both for the PD and alcohol consumption whereas the number of shared genes for the PD and the type II diabetes is 51. However, the PD shared 45, 43 and 42 significantly expressed genes with the ageing, high dietary fat and high body fat respectively. The PD shared less than 40 significant transcripts with other factors. Ontological and pathway analyses have identified significant gene ontology and molecular pathways that enhance our understanding of the fundamental molecular procedure of the PD progression. Therapeutic targets of the PD could be developed using these identified target genes, ontologies and pathways. Our formulated methodologies demonstrate a network-based approach to understand the disease mechanism and the causative reason of the PD, and the identification for therapeutic targets of the PD.",
				"prefix": "   \n  \n      \n  \n  \n    Abstract",
				"type": "TextQuoteSelector",
				"suffix": "  \n\n  \n  \n\n  \n      \n  \n  \n    C"
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/IGdhCPTfEeiXW-N5-QfGQQ",
			"html": "https://hypothes.is/a/IGdhCPTfEeiXW-N5-QfGQQ",
			"incontext": "https://hyp.is/IGdhCPTfEeiXW-N5-QfGQQ/www.biorxiv.org/content/early/2018/11/30/482760"
		},
		"tags": ["Parkinson's Disease", "PD", "Ageing", "Severe Alcohol Consumption", "Type 2 Diabetes", "High Body Fat", "Hypercholesterolemia", "High Dietary Fat", "Red Meaat", "Sedentary Lifestyle", "Smoking", "Dysregulated Genes"],
		"text": "",
		"created": "2018-11-30T20:32:58.931424+00:00",
		"uri": "https://www.biorxiv.org/content/early/2018/11/30/482760",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["A System Biology Approach to Identify the Genetic Markers to the progression of Parkinson's disease for Aging, lifestyle and Type 2 Diabetes"]
		},
		"id": "IGdhCPTfEeiXW-N5-QfGQQ",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-11-25T18:26:43.177300+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "http://science.sciencemag.org/content/362/6416/770.full",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "p-12"
			}, {
				"endContainer": "/div[2]/div[1]/div[1]/div[1]/div[1]/article[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/p[2]",
				"startContainer": "/div[2]/div[1]/div[1]/div[1]/div[1]/article[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/p[2]",
				"type": "RangeSelector",
				"startOffset": 934,
				"endOffset": 1635
			}, {
				"type": "TextPositionSelector",
				"end": 21344,
				"start": 20643
			}, {
				"exact": "The circadian clock provides a conserved mechanism that allows organisms to anticipate and respond to environmental changes. This perpetual rhythm leads to the timely expression of clock-controlled genes, especially those encompassing enzymes and regulatory molecules that mediate physiological and metabolic functions. A strong relation exists between the circadian clock and metabolism, as they share some common regulators. Indeed, TRF can restore cycling of metabolic regulators, such as nicotinamide phosphoribosyltransferase (NAMPT), cAMP response element\u2013binding protein, mTOR, AMPK, or the insulin signaling pathway, all of which take part in the life-span and health-span benefits of CR (40) ",
				"prefix": " circadian rhythm (3) (Fig. 3). ",
				"type": "TextQuoteSelector",
				"suffix": "(Fig. 3).\n  \n    <img class=\"fra"
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/qOwUFPDfEei1eodiJLXrHw",
			"html": "https://hypothes.is/a/qOwUFPDfEei1eodiJLXrHw",
			"incontext": "https://hyp.is/qOwUFPDfEei1eodiJLXrHw/science.sciencemag.org/content/362/6416/770.full"
		},
		"tags": ["Circadian Clock", "Circadian Rhythm", "cAMP", "Metabolic Function", "Metabolism", "Nicotinamide Phosphoribosyltransferease", "NAMPT", "Clock-controlled Genes", "Enzymes", "Regulatory Molecules", "TRF", "Time-restricted Feeding", "Diet"],
		"text": "",
		"created": "2018-11-25T18:26:43.177300+00:00",
		"uri": "http://science.sciencemag.org/content/362/6416/770.full",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["A time to fast"]
		},
		"id": "qOwUFPDfEei1eodiJLXrHw",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-11-15T18:29:36.699613+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "http://care.diabetesjournals.org/content/41/3/398",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "abstract-1"
			}, {
				"endContainer": "/div[4]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[13]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/p[1]",
				"startContainer": "/div[4]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[13]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]/strong[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 146
			}, {
				"type": "TextPositionSelector",
				"end": 6858,
				"start": 5130
			}, {
				"exact": "OBJECTIVE Gut microbiota represent a potential novel target for future prediabetes and type 2 diabetes therapies. In that respect, niacin has been shown to beneficially affect the host-microbiome interaction in rodent models.RESEARCH DESIGN AND METHODS We characterized more than 500 human subjects with different metabolic phenotypes regarding their niacin (nicotinic acid [NA] and nicotinamide [NAM]) status and their gut microbiome. In addition, NA and NAM delayed-release microcapsules were engineered and examined in vitro and in vivo in two human intervention studies (bioavailability study and proof-of-concept/safety study).RESULTS We found a reduced \u03b1-diversity and Bacteroidetes abundance in the microbiome of obese human subjects associated with a low dietary niacin intake. We therefore developed delayed-release microcapsules targeting the ileocolonic region to deliver increasing amounts of NA and NAM to the microbiome while preventing systemic resorption to avoid negative side effects (e.g., facial flushing). In vitro studies on these delayed-release microcapsules revealed stable conditions at pH 1.4, 4.5, and 6.8, followed by release of the compounds at pH 7.4, simulating the ileocolonic region. In humans in vivo, gut-targeted delayed-release NA but not NAM produced a significant increase in the abundance of Bacteroidetes. In the absence of systemic side effects, these favorable microbiome changes induced by microencapsulated delayed-release NA were associated with an improvement of biomarkers for systemic insulin sensitivity and metabolic inflammation.CONCLUSION Targeted microbiome intervention by delayed-release NA might represent a future therapeutic option for prediabetes and type 2 diabetes.",
				"prefix": "   \n  \n      \n  \n  \n    Abstract",
				"type": "TextQuoteSelector",
				"suffix": "IntroductionRather than being vi"
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/aDWYzukEEeiqFR8FSRDesg",
			"html": "https://hypothes.is/a/aDWYzukEEeiqFR8FSRDesg",
			"incontext": "https://hyp.is/aDWYzukEEeiqFR8FSRDesg/care.diabetesjournals.org/content/41/3/398"
		},
		"tags": ["Gut Microbiota", "Prediabetes", "Type 2 Diabetes", "Niacin", "\u03b1-diversity", "Bacteroidetes", "Microbiome", "Insulin Sensitivity", "Metabolic Inflammation"],
		"text": "",
		"created": "2018-11-15T18:29:36.699613+00:00",
		"uri": "http://care.diabetesjournals.org/content/41/3/398",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["Targeted Microbiome Intervention by Microencapsulated Delayed-Release Niacin Beneficially Affects Insulin Sensitivity in Humans"]
		},
		"id": "aDWYzukEEeiqFR8FSRDesg",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-11-15T18:24:04.716358+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4305274/",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "P2"
			}, {
				"endContainer": "/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]/div[2]/p[1]",
				"startContainer": "/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]/div[2]/p[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 1057
			}, {
				"type": "TextPositionSelector",
				"end": 7246,
				"start": 6189
			}, {
				"exact": "Commensal gut microflora and dietary fiber protect against colonic inflammation and colon cancer through unknown targets. Butyrate, a bacterial product from fermentation of dietary fiber in the colon, has been implicated in this process. GPR109A (encoded by Niacr1) is a receptor for butyrate in the colon. GPR109A is also a receptor for niacin, which is also produced by gut microbiota and suppresses intestinal inflammation. Here we showed that Gpr109a signaling promoted anti-inflammatory properties in colonic macrophages and dendritic cells and enabled them to induce differentiation of Treg cells and IL-10-producing T cells. Moreover, Gpr109a was essential for butyrate-mediated induction of IL-18 in colonic epithelium. Consequently, Niacr1\u2212/\u2212 mice were susceptible to development of colonic inflammation and colon cancer. Niacin, a pharmacological Gpr109a agonist, suppressed colitis and colon cancer in a Gpr109a-dependent manner. Thus, Gpr10a has an essential role in mediating the beneficial effects of gut microbiota and dietary fiber in colon.",
				"prefix": "ary_data.pdf (3.8M)Go to:SUMMARY",
				"type": "TextQuoteSelector",
				"suffix": "Go to:INTRODUCTIONCommensal micr"
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/oirYTOkDEeiv4stM26KCyQ",
			"html": "https://hypothes.is/a/oirYTOkDEeiv4stM26KCyQ",
			"incontext": "https://hyp.is/oirYTOkDEeiv4stM26KCyQ/www.ncbi.nlm.nih.gov/pmc/articles/PMC4305274/"
		},
		"tags": ["Gut Microflora", "Microbiome", "Commensal Gut Microflora", "Dietary Fiber", "Colonic Inflammation", "Colon Cancer", "Butyrate", "Fermentation", "Colon", "GPR109a", "Niacr1", "Niacin", "Gut Microbiota", "Intestinl Inflammation", "GPR109a Signalling", "Anti-inflammatory Properties", "Colonic Macrophages", "Dendritic Cells", "Treg Cells", "IL-10", "IL-10-Producing T Cells", "Butyrate-mediated Induction", "IL-18", "Colonic Epithelium", "Colitis"],
		"text": "",
		"created": "2018-11-15T18:24:04.716358+00:00",
		"uri": "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4305274/",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["Activation of the receptor (Gpr109a) for niacin and the commensal metabolite butyrate suppresses colonic inflammation and carcinogenesis"]
		},
		"id": "oirYTOkDEeiv4stM26KCyQ",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-11-15T18:18:43.752171+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4337780/",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "P1"
			}, {
				"endContainer": "/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/p[1]",
				"startContainer": "/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/p[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 366
			}, {
				"type": "TextPositionSelector",
				"end": 3190,
				"start": 2824
			}, {
				"exact": "A complex partnership between the host and the vast intestinal microbial\necosystem serves numerous biological activities including nutrition, immunity,\nand barrier function. In this issue of Immunity, Singh et al. (2014) demonstrate that\nmicrobial-derived butyrate mediated its protective activity against inflammation\nand colorectal cancer through GPR109a signaling",
				"prefix": "published article.Go to:Abstract",
				"type": "TextQuoteSelector",
				"suffix": ".From birth to adulthood, humans"
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/4tyQAukCEeiSAFOSnybXOw",
			"html": "https://hypothes.is/a/4tyQAukCEeiSAFOSnybXOw",
			"incontext": "https://hyp.is/4tyQAukCEeiSAFOSnybXOw/www.ncbi.nlm.nih.gov/pmc/articles/PMC4337780/"
		},
		"tags": ["Microbiome", "Inflammation", "Colorectal Cancer", "GPR109a", "GPR109a Signaling"],
		"text": "",
		"created": "2018-11-15T18:18:43.752171+00:00",
		"uri": "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4337780/",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["GPR109a: The Missing Link between Microbiome and Good\nHealth?"]
		},
		"id": "4tyQAukCEeiSAFOSnybXOw",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-11-11T22:12:09.700367+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://insight.jci.org/articles/view/95687?utm_content=buffer3b5bd&utm_medium=social&utm_source=twitter.com&utm_campaign=buffer",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "section-abstract"
			}, {
				"endContainer": "/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[10]/dl[1]/dd[1]/div[1]/p[1]",
				"startContainer": "/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[10]/dl[1]/dd[1]/div[1]/p[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 1311
			}, {
				"type": "TextPositionSelector",
				"end": 7159,
				"start": 5848
			}, {
				"exact": "Three Akt isoforms, encoded by 3 separate genes, are expressed in mammals. While the roles of Akt1 and Akt2 in metabolism are well established, it is not yet known whether Akt3 plays a role in metabolic diseases. We now report that Akt3 protects mice from high-fat diet\u2013induced obesity by suppressing an alternative pathway of adipogenesis via with no lysine protein kinase-1 (WNK1) and serum/glucocorticoid-inducible kinase 1 (SGK1). We demonstrate that Akt3 specifically phosphorylates WNK1 at T58 and promotes its degradation via the ubiquitin-proteasome pathway. A lack of Akt3 in adipocytes increases the WNK1 protein level, leading to activation of SGK1. SGK1, in turn, promotes adipogenesis by phosphorylating and inhibiting transcription factor FOXO1 and, subsequently, activating the transcription of PPAR\u03b3 in adipocytes. Akt3-deficient mice have an increased number of adipocytes and, when fed a high-fat diet, display increased weight gain, white adipose tissue expansion, and impaired glucose homeostasis. Pharmacological blockade of SGK1 in high-fat diet\u2013fed Akt3-deficient mice suppressed adipogenesis, prevented excessive weight gain and adiposity, and ameliorated metabolic parameters. Thus, Akt3/WNK1/SGK1 represents a potentially novel signaling pathway controlling the development of obesity.",
				"prefix": "er 17, 2017\n\n\n\n\n\n\n\n\t\t\t\n\nAbstract",
				"type": "TextQuoteSelector",
				"suffix": "\n\n\nIntroduction\nAdipocyte hyperp"
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/1VtVjOX-EeieFYMG3sxVoA",
			"html": "https://hypothes.is/a/1VtVjOX-EeieFYMG3sxVoA",
			"incontext": "https://hyp.is/1VtVjOX-EeieFYMG3sxVoA/insight.jci.org/articles/view/95687?utm_content=buffer3b5bd&utm_medium=social&utm_source=twitter.com&utm_campaign=buffer"
		},
		"tags": ["Akt Isoforms", "Akt1", "Akt2", "Akt3", "Metabolism", "Obesity", "High Fat Diet", "Lysine Protein Kinase-1", "WNK1", "Serum/glucocorticoid-inducible Kinase 1", "SGK1", "Adopocytes", "Adipose Tissue", "Glucose Homeostasis", "Adipogenesis", "Weight Gain", "Adiposity", "Signaling Pathway"],
		"text": "",
		"created": "2018-11-11T22:12:09.700367+00:00",
		"uri": "https://insight.jci.org/articles/view/95687?utm_content=buffer3b5bd&utm_medium=social&utm_source=twitter.com&utm_campaign=buffer",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["Akt3 inhibits adipogenesis and protects from diet-induced obesity via WNK1/SGK1 signaling"]
		},
		"id": "1VtVjOX-EeieFYMG3sxVoA",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-11-07T15:44:08.809029+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://www.frontiersin.org/articles/10.3389/fnins.2018.00735/full",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "article"
			}, {
				"endContainer": "/div[3]/div[3]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[2]/p[1]/b[19]",
				"startContainer": "/div[3]/div[3]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[2]/p[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 1
			}, {
				"type": "TextPositionSelector",
				"end": 16414,
				"start": 14176
			}, {
				"exact": "Coffee consumption has been correlated with a decreased risk of developing Alzheimer\u2019s disease (AD) and Parkinson\u2019s disease (PD), but the mechanism by which coffee may provide neuroprotection in humans is not fully understood. We hypothesized that compounds found in brewed coffee may elicit neuroprotective effects by inhibiting the aggregation of amyloid-beta (A\u03b2) and tau (AD) or \u03b1-synuclein (PD). Three instant coffee extracts (light roast, dark roast, decaffeinated dark roast) and six coffee components [caffeine (1), chlorogenic acid (2), quinic acid (3), caffeic acid (4), quercetin (5), and phenylindane (6)] were investigated for their ability to inhibit the fibrillization of A\u03b2 and tau proteins using thioflavin T (ThT) and thioflavin S (ThS) fluorescence assays, respectively. Inhibition of A\u03b2 and \u03b1-synuclein oligomerization was assessed using ELISA assays. All instant coffee extracts inhibit fibrillization of A\u03b2 and tau, and promote \u03b1-synuclein oligomerization at concentrations above 100 \u03bcg/mL. Dark roast coffee extracts are more potent inhibitors of A\u03b2 oligomerization (IC50 ca. 10 \u03bcg/mL) than light roast coffee extract (IC50 = 40.3 \u03bcg/mL), and pure caffeine (1) has no effect on A\u03b2, tau or \u03b1-synuclein aggregation. Coffee components 2, 4, and 5 inhibit the fibrillization of A\u03b2 at 100 \u03bcM concentration, yet only 5 inhibits A\u03b2 oligomerization (IC50 = 10.3 \u03bcM). 1\u20135 have no effect on tau fibrillization. Coffee component 6, however, is a potent inhibitor of both A\u03b2 and tau fibrillization, and also inhibits A\u03b2 oligomerization (IC50 = 42.1 \u03bcM). Coffee components 4 and 5 promote the aggregation of \u03b1-synuclein at concentrations above 100 \u03bcM; no other coffee components affect \u03b1-synuclein oligomerization. While the neuroprotective effect of coffee consumption is likely due to a combination of factors, our data suggest that inhibition A\u03b2 and tau aggregation by phenylindane 6 (formed during the roasting of coffee beans, higher quantities found in dark roast coffees) is a plausible mechanism by which coffee may provide neuroprotection. The identification of 6 as a dual-inhibitor of both A\u03b2 and tau aggregation is noteworthy, and to our knowledge this is the first report of the aggregation inhibition activity of 6",
				"prefix": "f Toronto, Toronto, ON, Canada\n\n",
				"type": "TextQuoteSelector",
				"suffix": ".\n\n\n\nIntroduction\nCoffee is one "
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/90qVCOKjEeifSqtddFwK7g",
			"html": "https://hypothes.is/a/90qVCOKjEeifSqtddFwK7g",
			"incontext": "https://hyp.is/90qVCOKjEeifSqtddFwK7g/www.frontiersin.org/articles/10.3389/fnins.2018.00735/full"
		},
		"tags": ["Coffee", "Alzheimer's Disease", "Parkinson's Disease", "Beta Amyloid", "A\u03b2", "\u03b1-Synuclein", "Caffeine", "Clorogenic Acid", "Quinic Acid", "Caffeic Acid", "Quercetin", "Phenylindane", "Fibrillization", "Tau Proteins", "Thioflavin T", "Thioflavin S", "\u03b1-Synuclein Oligomerization", "Dark Roast"],
		"text": "",
		"created": "2018-11-07T15:44:08.809029+00:00",
		"uri": "https://www.frontiersin.org/articles/10.3389/fnins.2018.00735/full",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["Phenylindanes in Brewed Coffee Inhibit Amyloid-Beta and Tau Aggregation"]
		},
		"id": "90qVCOKjEeifSqtddFwK7g",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-11-06T04:08:36.433947+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://www.nature.com/articles/s41591-018-0216-2",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "Abs1-content"
			}, {
				"endContainer": "/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/section[1]/div[1]/div[1]/p[1]",
				"startContainer": "/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/section[1]/div[1]/div[1]/p[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 1710
			}, {
				"type": "TextPositionSelector",
				"end": 8086,
				"start": 6376
			}, {
				"exact": "Commensal gut bacterial communities (microbiomes) are predicted to influence human health and disease1,2. Neonatal gut microbiomes are colonized with maternal and environmental flora and mature toward a stable composition over\u20092\u20133 years3,4. To study pre- and postnatal determinants of infant microbiome development, we analyzed 402 fecal metagenomes from 60 infants aged 0\u20138\u2009months, using longitudinal generalized linear mixed models (GLMMs). Distinct microbiome signatures correlated with breastfeeding, formula ingredients, and maternal gestational weight gain (GWG). Amino acid synthesis pathway accretion in breastfed microbiomes complemented normative breastmilk composition. Prebiotic oligosaccharides, designed to promote breastfed-like microflora5, predicted functional pathways distinct from breastfed infant microbiomes. Soy formula in six infants was positively associated with Lachnospiraceae and pathways suggesting a short-chain fatty acid (SCFA)-rich environment, including glycerol to 1-butanol fermentation, which is potentially dysbiotic. GWG correlated with altered carbohydrate degradation and enriched vitamin synthesis pathways. Maternal and postnatal antibiotics predicted microbiome alterations, while delivery route had no persistent effects. Domestic water source correlates suggest water may be an underappreciated determinant of microbiome acquisition. Clinically important microbial pathways with statistically significant dietary correlates included dysbiotic markers6,7, core enterotype features8, and synthesis pathways for enteroprotective9 and immunomodulatory10,11 metabolites, epigenetic mediators1, and developmentally critical vitamins12, warranting further investigation.",
				"prefix": "                AbstractAbstract",
				"type": "TextQuoteSelector",
				"suffix": "\n\n                        \n     "
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/ooKfCuF5EeiQDG9Rm5rPAg",
			"html": "https://hypothes.is/a/ooKfCuF5EeiQDG9Rm5rPAg",
			"incontext": "https://hyp.is/ooKfCuF5EeiQDG9Rm5rPAg/www.nature.com/articles/s41591-018-0216-2"
		},
		"tags": ["Microbiome", "Neonatal Gut Microbiomes", "Prebiotic Oligosaccharides"],
		"text": "",
		"created": "2018-11-06T04:08:36.433947+00:00",
		"uri": "https://www.nature.com/articles/s41591-018-0216-2",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["Infant diet and maternal gestational weight gain predict early metabolic maturation of gut microbiomes"]
		},
		"id": "ooKfCuF5EeiQDG9Rm5rPAg",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-11-04T17:11:45.984093+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3402009/",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "__p1"
			}, {
				"endContainer": "/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/p[1]",
				"startContainer": "/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/p[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 2180
			}, {
				"type": "TextPositionSelector",
				"end": 4866,
				"start": 2686
			}, {
				"exact": "A novel hypothesis of obesity is suggested by consideration of diet-related inflammation and evolutionary medicine. The obese homeostatically guard their elevated weight. In rodent models of high-fat diet-induced obesity, leptin resistance is seen initially at vagal afferents, blunting the actions of satiety mediators, then centrally, with gastrointestinal bacterial-triggered SOCS3 signaling implicated. In humans, dietary fat and fructose elevate systemic lipopolysaccharide, while dietary glucose also strongly activates SOCS3 signaling. Crucially however, in humans, low-carbohydrate diets spontaneously decrease weight in a way that low-fat diets do not. Furthermore, nutrition transition patterns and the health of those still eating diverse ancestral diets with abundant food suggest that neither glycemic index, altered fat, nor carbohydrate intake can be intrinsic causes of obesity, and that human energy homeostasis functions well without Westernized foods containing flours, sugar, and refined fats. Due to being made up of cells, virtually all \u201cancestral foods\u201d have markedly lower carbohydrate densities than flour- and sugar-containing foods, a property quite independent of glycemic index. Thus the \u201cforgotten organ\u201d of the gastrointestinal microbiota is a prime candidate to be influenced by evolutionarily unprecedented postprandial luminal carbohydrate concentrations. The present hypothesis suggests that in parallel with the bacterial effects of sugars on dental and periodontal health, acellular flours, sugars, and processed foods produce an inflammatory microbiota via the upper gastrointestinal tract, with fat able to effect a \u201cdouble hit\u201d by increasing systemic absorption of lipopolysaccharide. This model is consistent with a broad spectrum of reported dietary phenomena. A diet of grain-free whole foods with carbohydrate from cellular tubers, leaves, and fruits may produce a gastrointestinal microbiota consistent with our evolutionary condition, potentially explaining the exceptional macronutrient-independent metabolic health of non-Westernized populations, and the apparent efficacy of the modern \u201cPaleolithic\u201d diet on satiety and metabolism.",
				"prefix": "r articles in PMC.Go to:Abstract",
				"type": "TextQuoteSelector",
				"suffix": "Keywords: carbohydrate density, "
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/taGieOBUEeiefLs4S_BCRw",
			"html": "https://hypothes.is/a/taGieOBUEeiefLs4S_BCRw",
			"incontext": "https://hyp.is/taGieOBUEeiefLs4S_BCRw/www.ncbi.nlm.nih.gov/pmc/articles/PMC3402009/"
		},
		"tags": ["Obesity", "Inflammation", "Leptin", "SOCS3", "Vagal Afferents", "Satiety Mediators", "Dietary Fat", "Fructose", "Lipopolysaccharide", "Glucose", "SOCS3 Signaling", "Carbohydrate", "Gastrointestinal Microbiota", "Microbiome", "Metabolism"],
		"text": "",
		"created": "2018-11-04T17:11:45.984093+00:00",
		"uri": "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3402009/",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["Comparison with ancestral diets suggests dense acellular carbohydrates promote an inflammatory microbiota, and may be the primary dietary cause of leptin resistance and obesity"]
		},
		"id": "taGieOBUEeiefLs4S_BCRw",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-11-04T17:07:45.419493+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3705319/",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "__p1"
			}, {
				"endContainer": "/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/p[1]",
				"startContainer": "/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/p[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 725
			}, {
				"type": "TextPositionSelector",
				"end": 3814,
				"start": 3089
			}, {
				"exact": "Wheat is one of the most consumed cereal grains worldwide and makes up a substantial part of the human diet. Although government-supported dietary guidelines in Europe and the U.S.A advise individuals to eat adequate amounts of (whole) grain products per day, cereal grains contain \u201canti-nutrients,\u201d such as wheat gluten and wheat lectin, that in humans can elicit dysfunction and disease. In this review we discuss evidence from in vitro, in vivo and human intervention studies that describe how the consumption of wheat, but also other cereal grains, can contribute to the manifestation of chronic inflammation and autoimmune diseases by increasing intestinal permeability and initiating a pro-inflammatory immune response.",
				"prefix": "r articles in PMC.Go to:Abstract",
				"type": "TextQuoteSelector",
				"suffix": "Keywords: cereal grains, celiac "
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/sRbxvuBTEeiSV3NzUpxekw",
			"html": "https://hypothes.is/a/sRbxvuBTEeiSV3NzUpxekw",
			"incontext": "https://hyp.is/sRbxvuBTEeiSV3NzUpxekw/www.ncbi.nlm.nih.gov/pmc/articles/PMC3705319/"
		},
		"tags": ["Cereal Grains", "Celiac Disease", "Gluten", "Gliadin", "Inflammation", "Intestinal Permeability", "Lectins", "Wheat", "Wheat Germ Agglutinin", "Chronic Inflammation", "Pro-inflammatory Immune Response", "Autoimmune Disease", "Il-6", "TNF-\u03b1", "Tumor Necrosis Factor--\u03b1"],
		"text": "",
		"created": "2018-11-04T17:04:29.024242+00:00",
		"uri": "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3705319/",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["The Dietary Intake of Wheat and other Cereal Grains and Their Role in Inflammation"]
		},
		"id": "sRbxvuBTEeiSV3NzUpxekw",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-11-03T17:35:26.525840+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://journals.plos.org/plosbiology/article?id=10.1371/journal.pbio.2006519",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "artText"
			}, {
				"endContainer": "/main[1]/div[1]/section[1]/div[1]/div[3]/div[1]/div[2]/h2[1]",
				"startContainer": "/main[1]/div[1]/section[1]/div[1]/div[3]/div[1]/div[1]/p[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 0
			}, {
				"type": "TextPositionSelector",
				"end": 15595,
				"start": 14365
			}, {
				"exact": "Copper (Cu) has emerged as an important modifier of body lipid metabolism. However, how Cu contributes to the physiology of fat cells remains largely unknown. We found that adipocytes require Cu to establish a balance between main metabolic fuels. Differentiating adipocytes increase their Cu uptake along with the ATP7A-dependent transport of Cu into the secretory pathway to activate a highly up-regulated amino-oxidase copper-containing 3 (AOC3)/semicarbazide-sensitive amine oxidase (SSAO); in vivo, the activity of SSAO depends on the organism\u2019s Cu status. Activated SSAO oppositely regulates uptake of glucose and long-chain fatty acids and remodels the cellular proteome to coordinate changes in fuel availability and related downstream processes, such as glycolysis, de novo lipogenesis, and sphingomyelin/ceramide synthesis. The loss of SSAO-dependent regulation due to Cu deficiency, limited Cu transport to the secretory pathway, or SSAO inactivation shifts metabolism towards lipid-dependent pathways and results in adipocyte hypertrophy and fat accumulation. The results establish a role for Cu homeostasis in adipocyte metabolism and identify SSAO as a regulator of energy utilization processes in adipocytes.\n\n\n\n\n  ",
				"prefix": "\n\n\n        \n        \n\n\n\nAbstract",
				"type": "TextQuoteSelector",
				"suffix": "Figures\n\n  \n\n    \n      \n\n      "
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/2gyZfN-OEeiiihsKgbSEzQ",
			"html": "https://hypothes.is/a/2gyZfN-OEeiiihsKgbSEzQ",
			"incontext": "https://hyp.is/2gyZfN-OEeiiihsKgbSEzQ/journals.plos.org/plosbiology/article?id=10.1371/journal.pbio.2006519"
		},
		"tags": ["Copper", "CU", "Lipid Metabolism", "ATP7A-dependent Transport", "Fatty Acids", "Cellular Proteome", "Glycolysis", "Lipogenesis", "Sphingomyelin-Ceramide Synthesis", "Lipid-dependent Pathways", "Cu Deficiency", "Cu Transport", "Secretory Pathway", "Adipocyte"],
		"text": "",
		"created": "2018-11-03T17:35:26.525840+00:00",
		"uri": "https://journals.plos.org/plosbiology/article?id=10.1371/journal.pbio.2006519",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["Copper-dependent amino oxidase 3 governs selection of metabolic fuels in adipocytes"]
		},
		"id": "2gyZfN-OEeiiihsKgbSEzQ",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-10-29T02:22:03.583929+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://en.wikipedia.org/wiki/Imidazol-4-one-5-propionic_acid",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "mw-content-text"
			}, {
				"endContainer": "/div[3]/div[3]/div[4]/div[1]/p[1]",
				"startContainer": "/div[3]/div[3]/div[4]/div[1]/p[1]/b[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 316
			}, {
				"type": "TextPositionSelector",
				"end": 1260,
				"start": 944
			}, {
				"exact": "Imidazol-4-one-5-propionic acid is an intermediate in the metabolism of histidine.  It is a colorless compound that is sensitive to light in air.[1] It arises via the action of urocanase on urocanic acid.  Hydrolysis of the heterocycle to the glutamic acid derivative is catalyzed by imidazolonepropionate hydrolase.",
				"prefix": "\u00a0?)\n\n\nInfobox\u00a0references\n\n\n\n\n\n\n\n",
				"type": "TextQuoteSelector",
				"suffix": "\n\nSee also[edit]\nFormiminoglutam"
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/bJjGetshEei4BqM0Ec-xkA",
			"html": "https://hypothes.is/a/bJjGetshEei4BqM0Ec-xkA",
			"incontext": "https://hyp.is/bJjGetshEei4BqM0Ec-xkA/en.wikipedia.org/wiki/Imidazol-4-one-5-propionic_acid"
		},
		"tags": ["Imidazol Proprionate", "Histidine", "Hydrolysis"],
		"text": "",
		"created": "2018-10-29T02:22:03.583929+00:00",
		"uri": "https://en.wikipedia.org/wiki/Imidazol-4-one-5-propionic_acid",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["Imidazol-4-one-5-propionic acid - Wikipedia"]
		},
		"id": "bJjGetshEei4BqM0Ec-xkA",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-10-28T16:42:06.711000+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://nutritionfacts.org/2018/10/23/how-to-treat-lupus-with-turmeric/",
			"selector": [{
				"endContainer": "/div[2]/div[1]/main[1]/article[1]/div[1]/p[3]",
				"startContainer": "/div[2]/div[1]/main[1]/article[1]/div[1]/p[3]",
				"type": "RangeSelector",
				"startOffset": 66,
				"endOffset": 160
			}, {
				"type": "TextPositionSelector",
				"end": 3692,
				"start": 3598
			}, {
				"exact": "oral supplementation of turmeric decreases proteinuria, hematuria, and systolic blood pressure",
				"prefix": "us with Turmeric: Good as Gold, ",
				"type": "TextQuoteSelector",
				"suffix": "\u2014the cardinal clinical manifesta"
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/aAx6RNrQEeiusiMAFPXEUw",
			"html": "https://hypothes.is/a/aAx6RNrQEeiusiMAFPXEUw",
			"incontext": "https://hyp.is/aAx6RNrQEeiusiMAFPXEUw/nutritionfacts.org/2018/10/23/how-to-treat-lupus-with-turmeric/"
		},
		"tags": ["Turmeric", "Proteinuria", "Decreases", "Hematuria", "Systolic BP"],
		"text": "",
		"created": "2018-10-28T16:42:06.711000+00:00",
		"uri": "https://nutritionfacts.org/2018/10/23/how-to-treat-lupus-with-turmeric/",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["How to Treat Lupus with Turmeric | NutritionFacts.org"]
		},
		"id": "aAx6RNrQEeiusiMAFPXEUw",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-10-26T01:23:23.616494+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://www.ncbi.nlm.nih.gov/pubmed/26758574",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "maincontent"
			}, {
				"endContainer": "/div[2]/div[1]/form[1]/div[1]/div[5]/div[1]/div[5]/div[1]/div[4]/div[1]/p[1]",
				"startContainer": "/div[2]/div[1]/form[1]/div[1]/div[5]/div[1]/div[5]/div[1]/div[4]/div[1]/p[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 1489
			}, {
				"type": "TextPositionSelector",
				"end": 8481,
				"start": 6992
			}, {
				"exact": "Herbal medicines with high amounts of phytochemicals have been shown to have beneficial effects on blood pressure (BP), endothelial function and anthropometric measures. This study aimed to determine the effect of herbal treatment on BP, endothelial function and anthropometric measures in patients with type 2 diabetes mellitus (T2DM). This clinical trial included 204 T2DM patients randomly assigned to four intervention groups receiving 3 g cinnamon, 3 g cardamom, 1 g saffron or 3 g ginger with three glasses of black tea, and one control group consuming only three glasses of tea without any herbals, for 8 weeks. Intercellular adhesion molecule-1 (ICAM-1), systolic and diastolic BP and anthropometric measures were collected at baseline and after 8 weeks. No significant difference was found between various medicinal plants in terms of influencing BP, serum soluble (s)ICAM-1 concentrations and anthropometric measures. However, in within-group comparison saffron and ginger intakes significantly reduced sICAM-1 concentrations (340.9\u2009\u00b1\u200914.4 vs 339.69\u2009\u00b1\u200914.4 ng/ml, p\u2009=\u20090.01, and 391.78\u2009\u00b1\u200916.0 vs 390.97\u2009\u00b1\u200915.8 ng/ml, p\u2009=\u20090.009, respectively) and ginger intake affected systolic BP (143.06\u2009\u00b1\u20090.2 vs 142.07\u2009\u00b1\u20090.2\u2009mmHg, p\u2009=\u20090.02). Although administration of these herbal medicines as supplementary remedies could affect BP and sICAM-1 concentrations, there was no significant difference between the plants in terms of influencing anthropometric measures, BP and endothelial function.",
				"prefix": " University , Australia.Abstract",
				"type": "TextQuoteSelector",
				"suffix": "KEYWORDS: Blood pressure; diabet"
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/u0WryNi9Eeinr9eRaJi0Ew",
			"html": "https://hypothes.is/a/u0WryNi9Eeinr9eRaJi0Ew",
			"incontext": "https://hyp.is/u0WryNi9Eeinr9eRaJi0Ew/www.ncbi.nlm.nih.gov/pubmed/26758574"
		},
		"tags": ["Cinnamon", "Cardamon", "Saffron", "Ginger", "Herbal Medicines", "Phytochemicals", "Blood Pressure", "BP", "Endothelial Function", "Type 2 Diabetes", "Black Tea", "Intercellular Adhesion Molecule-1", "ICAM-1", "Systolic BP", "Diastolic BP"],
		"text": "",
		"created": "2018-10-26T01:23:23.616494+00:00",
		"uri": "https://www.ncbi.nlm.nih.gov/pubmed/26758574",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["Effect of cinnamon, cardamom, saffron and ginger consumption on blood pressure and a marker of endothelial function in patients with type 2 diabete... - PubMed - NCBI"]
		},
		"id": "u0WryNi9Eeinr9eRaJi0Ew",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-10-26T01:17:50.737449+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://www.ncbi.nlm.nih.gov/pubmed/25719344",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "maincontent"
			}, {
				"endContainer": "/div[2]/div[1]/form[1]/div[1]/div[5]/div[1]/div[5]/div[1]/div[3]/div[1]/p[4]",
				"startContainer": "/div[2]/div[1]/form[1]/div[1]/div[5]/div[1]/div[5]/div[1]/div[3]/div[1]/h4[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 145
			}, {
				"type": "TextPositionSelector",
				"end": 8224,
				"start": 6436
			}, {
				"exact": "BACKGROUND: Ginger (Zingiber officinale) is one of the functional foods which contains biological compounds including gingerol, shogaol, paradol and zingerone. Ginger has been proposed to have anti-cancer, anti-thrombotic, anti-inflammatory, anti-arthritic, hypolipidemic and analgesic properties. Here, we report the effect of ginger supplementation on glycemic indices in Iranian patients with type 2 diabetes.METHODS: A double-blind, placebo-controlled, randomized clinical trial was conducted on 20-60 -year-old patients with type 2 diabetes who did not receive insulin. Participants in the intervention and control groups were received 3 g of powdered ginger or placebo (lactose) (in capsules) daily for 3 months. Glycemic indices, total antioxidant capacity (TAC), malondialdehyde (MDA), C-reactive protein (CRP), serum paraoxonase, dietary intake and physical activity were measured at the beginning and end of the study, and after 12 h fasting.RESULTS: Comparison of the indices after 3 months showed that the differences between the ginger and placebo groups were statistically significant as follows: serum glucose (-19.41 \u00b1 18.83 vs. 1.63 \u00b1 4.28 mg/dL, p < 0.001), HbA1c percentage (-0.77 \u00b1 0.88 vs. 0.02 \u00b1 0.16%, p < 0.001), insulin (-1.46 \u00b1 1.7 vs. 0.09 \u00b1 0.34 \u03bcIU/mL, p < 0.001), insulin resistance (-16.38 \u00b1 19.2 vs. 0.68 \u00b1 2.7, p < 0.001), high-sensitive CRP (-2.78 \u00b1 4.07 vs. 0.2 \u00b1 0.77 mg/L, p < 0.001), paraoxonase-1 (PON-1) (22.04 \u00b1 24.53 vs. 1.71 \u00b1 2.72 U/L, p < 0.006), TAC (0.78 \u00b1 0.71 vs. -0.04 \u00b1 0.29 \u00b5IU/mL, p < 0.01) and MDA (-0.85 \u00b1 1.08 vs. 0.06 \u00b1 0.08 \u00b5mol/L, p < 0.001) were significantly different.CONCLUSIONS: This report shows that the 3 months supplementation of ginger improved glycemic indices, TAC and PON-1 activity in patients with type 2 diabetes.",
				"prefix": ", Hosseini S, Shidfar S.Abstract",
				"type": "TextQuoteSelector",
				"suffix": "PMID: 25719344  DOI: 10.1515/jci"
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/9Nv2pNi8Eeieyv9ReN36VQ",
			"html": "https://hypothes.is/a/9Nv2pNi8Eeieyv9ReN36VQ",
			"incontext": "https://hyp.is/9Nv2pNi8Eeieyv9ReN36VQ/www.ncbi.nlm.nih.gov/pubmed/25719344"
		},
		"tags": ["Ginger", "Zingiber Officinale", "Glycemic Markers", "Type 2 Diabetes", "C-reactive Protein", "CRP", "Maiondialdehyde", "MDA", "Total Antioxidant Capacity", "TAC", "Glycemic Indices"],
		"text": "",
		"created": "2018-10-26T01:17:50.737449+00:00",
		"uri": "https://www.ncbi.nlm.nih.gov/pubmed/25719344",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["The effect of ginger (Zingiber officinale) on glycemic markers in patients with type 2 diabetes. - PubMed - NCBI"]
		},
		"id": "9Nv2pNi8Eeieyv9ReN36VQ",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}, {
		"updated": "2018-10-26T01:13:25.544071+00:00",
		"group": "n9iXjarQ",
		"target": [{
			"source": "https://www.ncbi.nlm.nih.gov/pubmed/24490949",
			"selector": [{
				"conformsTo": "https://tools.ietf.org/html/rfc3236",
				"type": "FragmentSelector",
				"value": "maincontent"
			}, {
				"endContainer": "/div[2]/div[1]/form[1]/div[1]/div[5]/div[1]/div[5]/div[1]/div[4]/div[1]/p[4]",
				"startContainer": "/div[2]/div[1]/form[1]/div[1]/div[5]/div[1]/div[5]/div[1]/div[4]/div[1]/h4[1]",
				"type": "RangeSelector",
				"startOffset": 0,
				"endOffset": 229
			}, {
				"type": "TextPositionSelector",
				"end": 7645,
				"start": 6648
			}, {
				"exact": "OBJECTIVE: To assess the effect of ginger consumption on glycemic status, lipid profile and some inflammatory markers in patients with type 2 diabetes mellitus.METHODS: In a double-blinded, placebo-controlled clinical trial, 70 type 2 diabetic patients were enrolled. They allocated randomly into ginger group and control group. They consumed 1600\u2009mg ginger versus 1600\u2009mg wheat flour placebo daily for 12 weeks. Serum sugar, lipids, CRP, PGE2 and TNF\u03b1 were measured before and after intervention.RESULTS: Ginger reduced fasting plasma glucose, HbA1C, insulin, HOMA, triglyceride, total cholesterol, CRP and PGE\u2082 significantly compared with placebo group (p\u2009<\u20090.05). There were no significant differences in HDL, LDL and TNF\u03b1 between two groups (p\u2009>\u20090.05).CONCLUSION: Ginger improved insulin sensitivity and some fractions of lipid profile, and reduced CRP and PGE\u2082 in type 2 diabetic patients. Therefore ginger can be considered as an effective treatment for prevention of diabetes complications.",
				"prefix": "iences , Tehran , Iran .Abstract",
				"type": "TextQuoteSelector",
				"suffix": "KEYWORDS: Blood sugar; ginger; i"
			}]
		}],
		"links": {
			"json": "https://hypothes.is/api/annotations/VsYS4ti8EeiTAt_6ia5RBQ",
			"html": "https://hypothes.is/a/VsYS4ti8EeiTAt_6ia5RBQ",
			"incontext": "https://hyp.is/VsYS4ti8EeiTAt_6ia5RBQ/www.ncbi.nlm.nih.gov/pubmed/24490949"
		},
		"tags": ["Ginger", "Glycemic Status", "Lipid Profile", "Inflammatory Biomarkers", "Type 2 Diabetes", "Serum Sugar", "Lipids", "CRP", "PGE2", "TNF\u03b1", "Fasting Blood Glucose", "HbA1c", "Insulin", "HOMA", "Triglyceride", "Total Cholesterol", "HDL", "LDL", "Insulin Sensitivity"],
		"text": "",
		"created": "2018-10-26T01:13:25.544071+00:00",
		"uri": "https://www.ncbi.nlm.nih.gov/pubmed/24490949",
		"flagged": false,
		"user_info": {
			"display_name": null
		},
		"user": "acct:Gardener@hypothes.is",
		"hidden": false,
		"document": {
			"title": ["The effect of ginger consumption on glycemic status, lipid profile and some inflammatory markers in patients with type 2 diabetes mellitus. - PubMed - NCBI"]
		},
		"id": "VsYS4ti8EeiTAt_6ia5RBQ",
		"permissions": {
			"read": ["group:n9iXjarQ"],
			"admin": ["acct:Gardener@hypothes.is"],
			"update": ["acct:Gardener@hypothes.is"],
			"delete": ["acct:Gardener@hypothes.is"]
		}
	}],
	"total": 143
}
*/
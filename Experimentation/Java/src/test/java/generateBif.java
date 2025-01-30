import org.junit.jupiter.api.Test;

import static bayes.util.BifMapper.fromWekaBif;
import static bayes.util.BifMapper.toOpenMarkovBif;

public class generateBif {

    @Test
    public void test() {
        System.out.println(toOpenMarkovBif(fromWekaBif(weka)));
    }

    String weka = "<?xml version=\"1.0\"?>\n" +
            "<!-- DTD for the XMLBIF 0.3 format -->\n" +
            "<!DOCTYPE BIF [\n" +
            "\t<!ELEMENT BIF ( NETWORK )*>\n" +
            "\t      <!ATTLIST BIF VERSION CDATA #REQUIRED>\n" +
            "\t<!ELEMENT NETWORK ( NAME, ( PROPERTY | VARIABLE | DEFINITION )* )>\n" +
            "\t<!ELEMENT NAME (#PCDATA)>\n" +
            "\t<!ELEMENT VARIABLE ( NAME, ( OUTCOME |  PROPERTY )* ) >\n" +
            "\t      <!ATTLIST VARIABLE TYPE (nature|decision|utility) \"nature\">\n" +
            "\t<!ELEMENT OUTCOME (#PCDATA)>\n" +
            "\t<!ELEMENT DEFINITION ( FOR | GIVEN | TABLE | PROPERTY )* >\n" +
            "\t<!ELEMENT FOR (#PCDATA)>\n" +
            "\t<!ELEMENT GIVEN (#PCDATA)>\n" +
            "\t<!ELEMENT TABLE (#PCDATA)>\n" +
            "\t<!ELEMENT PROPERTY (#PCDATA)>\n" +
            "]>\n" +
            "\n" +
            "\n" +
            "<BIF VERSION=\"0.3\">\n" +
            "<NETWORK>\n" +
            "<NAME>clean_9940_withCPR0_0-weka.filters.unsupervised.attribute.Remove-V-R5,7-12,14,19,13,15-17,2,20-23,25-26,18,4,6,24-weka.filters.supervised.attribute.Discretize-Rfirst-last-precision6-weka.filters.unsupervised.attribute.ReplaceMissingValues</NAME>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>age</NAME>\n" +
            "<OUTCOME>&apos;(-inf-43.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(43.5-57.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(57.5-63.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(63.5-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>alat</NAME>\n" +
            "<OUTCOME>&apos;(-inf-15.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(15.5-24.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(24.5-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>albumin</NAME>\n" +
            "<OUTCOME>&apos;(-inf-41.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(41.5-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>amylase</NAME>\n" +
            "<OUTCOME>&apos;All&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>alkaline_phosphatase</NAME>\n" +
            "<OUTCOME>&apos;(-inf-84.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(84.5-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>basophils</NAME>\n" +
            "<OUTCOME>&apos;(-inf-0.045]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(0.045-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>bilirubine</NAME>\n" +
            "<OUTCOME>&apos;(-inf-7.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(7.5-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>calcium</NAME>\n" +
            "<OUTCOME>&apos;(-inf-2.395]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(2.395-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>creatinine</NAME>\n" +
            "<OUTCOME>&apos;(-inf-68.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(68.5-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>crp</NAME>\n" +
            "<OUTCOME>&apos;(-inf-3.05]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(3.05-13.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(13.5-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>eosinophils</NAME>\n" +
            "<OUTCOME>&apos;(-inf-0.095]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(0.095-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>hemoglobin</NAME>\n" +
            "<OUTCOME>&apos;(-inf-8.05]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(8.05-9.25]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(9.25-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>inr</NAME>\n" +
            "<OUTCOME>&apos;(-inf-0.795]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(0.795-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>lc</NAME>\n" +
            "<OUTCOME>false</OUTCOME>\n" +
            "<OUTCOME>true</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>ldh</NAME>\n" +
            "<OUTCOME>&apos;(-inf-187.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(187.5-212.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(212.5-275.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(275.5-417.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(417.5-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>leucocytes</NAME>\n" +
            "<OUTCOME>&apos;(-inf-6.165]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(6.165-7.855]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(7.855-11.15]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(11.15-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>lymphocytes</NAME>\n" +
            "<OUTCOME>&apos;All&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>monocytes</NAME>\n" +
            "<OUTCOME>&apos;(-inf-0.745]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(0.745-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>neutrophils</NAME>\n" +
            "<OUTCOME>&apos;(-inf-3.485]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(3.485-5.065]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(5.065-6.935]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(6.935-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>platelets</NAME>\n" +
            "<OUTCOME>&apos;(-inf-251.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(251.5-342.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(342.5-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>potassium</NAME>\n" +
            "<OUTCOME>&apos;All&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>sex</NAME>\n" +
            "<OUTCOME>female</OUTCOME>\n" +
            "<OUTCOME>male</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>smoking_binary</NAME>\n" +
            "<OUTCOME>current/former</OUTCOME>\n" +
            "<OUTCOME>never</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<VARIABLE TYPE=\"nature\">\n" +
            "<NAME>sodium</NAME>\n" +
            "<OUTCOME>&apos;(-inf-135.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(135.5-138.5]&apos;</OUTCOME>\n" +
            "<OUTCOME>&apos;(138.5-inf)&apos;</OUTCOME>\n" +
            "</VARIABLE>\n" +
            "<DEFINITION>\n" +
            "<FOR>age</FOR>\n" +
            "<TABLE>\n" +
            "0.047726815530074435 0.12628243814121906 0.10686984510158921 0.7191209012271172 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>alat</FOR>\n" +
            "<GIVEN>age</GIVEN>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<GIVEN>sex</GIVEN>\n" +
            "<TABLE>\n" +
            "0.2852664576802508 0.30407523510971785 0.4106583072100313 \n" +
            "0.11642743221690591 0.2759170653907496 0.6076555023923444 \n" +
            "0.3333333333333333 0.3333333333333333 0.3333333333333333 \n" +
            "0.2 0.2 0.6 \n" +
            "0.25696594427244585 0.4241486068111455 0.3188854489164087 \n" +
            "0.08996282527881042 0.2966542750929368 0.6133828996282528 \n" +
            "0.4263565891472868 0.3953488372093023 0.17829457364341086 \n" +
            "0.21518987341772153 0.31645569620253167 0.46835443037974683 \n" +
            "0.23116219667943805 0.43039591315453385 0.3384418901660281 \n" +
            "0.10405257393209201 0.3209200438116101 0.5750273822562979 \n" +
            "0.3236363636363636 0.3236363636363636 0.3527272727272727 \n" +
            "0.18787878787878787 0.34545454545454546 0.4666666666666667 \n" +
            "0.30465790060173836 0.41965678627145087 0.27568531312681077 \n" +
            "0.21152082186754723 0.37369290038525044 0.41478627774720234 \n" +
            "0.38106026280018124 0.3792478477571364 0.23969188944268238 \n" +
            "0.3173210161662818 0.36443418013856815 0.3182448036951501 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>albumin</FOR>\n" +
            "<GIVEN>age</GIVEN>\n" +
            "<GIVEN>crp</GIVEN>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<TABLE>\n" +
            "0.074 0.926 \n" +
            "0.125 0.875 \n" +
            "0.15579710144927536 0.8442028985507246 \n" +
            "0.25 0.75 \n" +
            "0.37058823529411766 0.6294117647058823 \n" +
            "0.5 0.5 \n" +
            "0.0959016393442623 0.9040983606557377 \n" +
            "0.17105263157894737 0.8289473684210527 \n" +
            "0.18734491315136476 0.8126550868486352 \n" +
            "0.3888888888888889 0.6111111111111112 \n" +
            "0.5520833333333334 0.4479166666666667 \n" +
            "0.6282051282051282 0.3717948717948718 \n" +
            "0.12219730941704036 0.8778026905829597 \n" +
            "0.13815789473684212 0.8618421052631579 \n" +
            "0.21636363636363637 0.7836363636363637 \n" +
            "0.1987179487179487 0.8012820512820513 \n" +
            "0.531496062992126 0.468503937007874 \n" +
            "0.5681818181818182 0.4318181818181818 \n" +
            "0.18937696100403406 0.8106230389959659 \n" +
            "0.17884322678843226 0.8211567732115678 \n" +
            "0.3702115494568325 0.6297884505431676 \n" +
            "0.3551212938005391 0.644878706199461 \n" +
            "0.69211324570273 0.30788675429726997 \n" +
            "0.7236340533672173 0.27636594663278274 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>amylase</FOR>\n" +
            "<GIVEN>age</GIVEN>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<TABLE>\n" +
            "1.0 \n" +
            "1.0 \n" +
            "1.0 \n" +
            "1.0 \n" +
            "1.0 \n" +
            "1.0 \n" +
            "1.0 \n" +
            "1.0 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>alkaline_phosphatase</FOR>\n" +
            "<GIVEN>age</GIVEN>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<TABLE>\n" +
            "0.6995753715498938 0.30042462845010615 \n" +
            "0.7 0.3 \n" +
            "0.7251082251082251 0.2748917748917749 \n" +
            "0.6225490196078431 0.37745098039215685 \n" +
            "0.692080378250591 0.30791962174940896 \n" +
            "0.4701834862385321 0.5298165137614679 \n" +
            "0.6671028790014093 0.3328971209985907 \n" +
            "0.5835622710622711 0.41643772893772896 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>basophils</FOR>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<TABLE>\n" +
            "0.5773937600860678 0.4226062399139322 \n" +
            "0.49860335195530725 0.5013966480446927 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>bilirubine</FOR>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<TABLE>\n" +
            "0.5163394298009683 0.48366057019903175 \n" +
            "0.5756185155626496 0.42438148443735035 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>calcium</FOR>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<TABLE>\n" +
            "0.7561188811188811 0.24388111888111888 \n" +
            "0.7081005586592178 0.2918994413407821 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>creatinine</FOR>\n" +
            "<GIVEN>age</GIVEN>\n" +
            "<GIVEN>sex</GIVEN>\n" +
            "<TABLE>\n" +
            "0.7253086419753086 0.27469135802469136 \n" +
            "0.11942675159235669 0.8805732484076433 \n" +
            "0.6151736745886655 0.38482632541133455 \n" +
            "0.17816901408450705 0.821830985915493 \n" +
            "0.6233396584440227 0.3766603415559772 \n" +
            "0.2616387337057728 0.7383612662942272 \n" +
            "0.5442451420029896 0.4557548579970105 \n" +
            "0.16802417235943248 0.8319758276405675 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>crp</FOR>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<GIVEN>smoking_binary</GIVEN>\n" +
            "<TABLE>\n" +
            "0.4551811207147713 0.35825968728755947 0.1865591919976692 \n" +
            "0.519982528936449 0.3133872024459489 0.1666302686176021 \n" +
            "0.29798744860419824 0.3365072495130924 0.36550530188270935 \n" +
            "0.42278481012658226 0.3468354430379747 0.23037974683544304 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>eosinophils</FOR>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<TABLE>\n" +
            "0.23258472296933835 0.7674152770306616 \n" +
            "0.3118515562649641 0.6881484437350359 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>hemoglobin</FOR>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<GIVEN>sex</GIVEN>\n" +
            "<GIVEN>smoking_binary</GIVEN>\n" +
            "<TABLE>\n" +
            "0.3291776552385519 0.5540637736753776 0.11675857108607049 \n" +
            "0.3490130197396052 0.5741285174296514 0.07685846283074338 \n" +
            "0.1838799151574482 0.4446076031979116 0.37151248164464024 \n" +
            "0.15856428895956384 0.4338936846887778 0.4075420263516583 \n" +
            "0.3909742724588781 0.48882328131590047 0.12020244622522143 \n" +
            "0.3004115226337449 0.6296296296296297 0.06995884773662552 \n" +
            "0.2924988903683977 0.4673768308921438 0.2401242787394585 \n" +
            "0.2 0.5096774193548387 0.2903225806451613 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>inr</FOR>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<TABLE>\n" +
            "0.014053254437869823 0.9859467455621301 \n" +
            "0.0029928172386272946 0.9970071827613727 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>lc</FOR>\n" +
            "<GIVEN>age</GIVEN>\n" +
            "<GIVEN>smoking_binary</GIVEN>\n" +
            "<TABLE>\n" +
            "0.9948979591836735 0.00510204081632653 \n" +
            "0.9807692307692307 0.019230769230769232 \n" +
            "0.8872611464968153 0.11273885350318472 \n" +
            "0.9713983050847458 0.028601694915254237 \n" +
            "0.747148288973384 0.25285171102661597 \n" +
            "0.9327272727272727 0.06727272727272728 \n" +
            "0.6385014306151645 0.3614985693848355 \n" +
            "0.8957665169980756 0.10423348300192431 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>ldh</FOR>\n" +
            "<GIVEN>age</GIVEN>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<TABLE>\n" +
            "0.6613756613756614 0.16613756613756614 0.13015873015873017 0.03492063492063492 0.007407407407407408 \n" +
            "0.38461538461538464 0.07692307692307693 0.38461538461538464 0.07692307692307693 0.07692307692307693 \n" +
            "0.6022481625594466 0.20968439256377 0.16472114137483787 0.02204928664072633 0.0012970168612191958 \n" +
            "0.391304347826087 0.19806763285024154 0.28502415458937197 0.0821256038647343 0.043478260869565216 \n" +
            "0.5421828908554572 0.22595870206489677 0.2 0.028908554572271386 0.0029498525073746312 \n" +
            "0.3211845102505695 0.2938496583143508 0.26651480637813213 0.08428246013667426 0.03416856492027335 \n" +
            "0.44912951595048806 0.22713092482640637 0.26154775083023046 0.05484552681895945 0.007346281573915669 \n" +
            "0.3392816289178678 0.20704644246167925 0.31137039579043696 0.10409517272935255 0.038206360100663465 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>leucocytes</FOR>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<GIVEN>smoking_binary</GIVEN>\n" +
            "<TABLE>\n" +
            "0.19858224898038454 0.2852010099048359 0.38347251893571566 0.1327442221790639 \n" +
            "0.3456331877729258 0.3224890829694323 0.27838427947598254 0.05349344978165939 \n" +
            "0.09541324102120294 0.2226308957161402 0.45932496754651664 0.2226308957161402 \n" +
            "0.18434343434343434 0.34595959595959597 0.33585858585858586 0.13383838383838384 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>lymphocytes</FOR>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<GIVEN>smoking_binary</GIVEN>\n" +
            "<TABLE>\n" +
            "1.0 \n" +
            "1.0 \n" +
            "1.0 \n" +
            "1.0 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>monocytes</FOR>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<GIVEN>smoking_binary</GIVEN>\n" +
            "<TABLE>\n" +
            "0.6057692307692307 0.3942307692307692 \n" +
            "0.7477064220183486 0.25229357798165136 \n" +
            "0.4976190476190476 0.5023809523809524 \n" +
            "0.7233502538071066 0.2766497461928934 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>neutrophils</FOR>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<GIVEN>smoking_binary</GIVEN>\n" +
            "<TABLE>\n" +
            "0.20227228588075355 0.3285103903670616 0.28248203534666927 0.18673528840551562 \n" +
            "0.31462882096069866 0.38275109170305677 0.20720524017467248 0.09541484716157206 \n" +
            "0.08286456079619213 0.24902639549978364 0.3407615750757248 0.32734746862829944 \n" +
            "0.14898989898989898 0.351010101010101 0.3106060606060606 0.1893939393939394 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>platelets</FOR>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<GIVEN>sex</GIVEN>\n" +
            "<GIVEN>smoking_binary</GIVEN>\n" +
            "<TABLE>\n" +
            "0.2888995444737473 0.40877487413090385 0.3023255813953488 \n" +
            "0.3389332213355733 0.4397312053758925 0.22133557328853423 \n" +
            "0.4488497307880568 0.36824930657529775 0.18290096263664546 \n" +
            "0.5356656065424807 0.33030440708768743 0.1340299863698319 \n" +
            "0.2062420919443273 0.3774778574441164 0.4162800506115563 \n" +
            "0.25102880658436216 0.4156378600823045 0.3333333333333333 \n" +
            "0.3484243231247226 0.3484243231247226 0.3031513537505548 \n" +
            "0.47096774193548385 0.3419354838709677 0.1870967741935484 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>potassium</FOR>\n" +
            "<GIVEN>creatinine</GIVEN>\n" +
            "<TABLE>\n" +
            "1.0 \n" +
            "1.0 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>sex</FOR>\n" +
            "<TABLE>\n" +
            "0.4604667538477014 0.5395332461522986 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>smoking_binary</FOR>\n" +
            "<TABLE>\n" +
            "0.7500754451262448 0.24992455487375514 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "<DEFINITION>\n" +
            "<FOR>sodium</FOR>\n" +
            "<GIVEN>creatinine</GIVEN>\n" +
            "<GIVEN>lc</GIVEN>\n" +
            "<TABLE>\n" +
            "0.11988716502115655 0.21781180737457184 0.6623010276042716 \n" +
            "0.24659464537341474 0.26726162517613905 0.4861437294504462 \n" +
            "0.06950469081004741 0.20185614849187936 0.7286391606980732 \n" +
            "0.15206096293730517 0.2691375129892622 0.5788015240734327 \n" +
            "</TABLE>\n" +
            "</DEFINITION>\n" +
            "</NETWORK>\n" +
            "</BIF>";
}

def selectPatternsToBeRemoved():
    toBeRemoved = []
    # Remove everything that contains "@", unknown help attributes, so removed
    toBeRemoved.append("@")
    # Remove everything that contains "ANDERE_VOLWASSENE_ZELFDE_EMAIL"
    toBeRemoved.append("ANDERE_VOLWASSENE_ZELFDE_EMAIL")
    # Remove everything that contains "sindstest", attributes that specify if complaints start before/after
    # Covid test. Don't care for our context
    toBeRemoved.append("sindstest")
    # Remove everything that contains "voortest", attributes that specify if complaints start before/after
    # # Covid test. Don't care for our context
    toBeRemoved.append("voortest")
    # Remove "aantal_vac_voor_test"
    toBeRemoved.append("aantal_vac_voor_test")
    # Remove everything that contains "age_"
    toBeRemoved.append("age_")
    # Remove everything that contains "ANTISTOFFEN"
    toBeRemoved.append("ANTISTOFFEN")
    # Remove everything that contains "ROND_TEST", attributes that specify if complaints start before/after
    # # Covid test. Don't care for our context
    toBeRemoved.append("ROND_TEST")
    # Remove everything that contains "Diff_days"
    toBeRemoved.append("Diff_days")
    # Remove everything that contains "admission"
    toBeRemoved.append("admission")
    # Remove everything that contains "symp", don't care about covid symptoms for network analysis
    toBeRemoved.append("symp")
    # Remove everything that contains "C_OXYGEN_USE"
    toBeRemoved.append("C_OXYGEN_USE")
    # Remove everything that contains "severity_covid"
    toBeRemoved.append("severity_covid")
    # Remove everything that contains "jaar"
    toBeRemoved.append("jaar")
    # Remove everything that contains "kwartaal"
    toBeRemoved.append("kwartaal")
    # Remove everything that contains "maand"
    toBeRemoved.append("maand")
    # Remove everything that contains "compleet"
    toBeRemoved.append("compleet")
    # Remove everything that contains "contact_"
    toBeRemoved.append("contact_")
    # Remove everything that contains "controle"
    toBeRemoved.append("controle")
    # Remove everything that contains "covid_test"
    toBeRemoved.append("covid_test")
    # Remove everything that contains "DOORLOOPTIJD"
    toBeRemoved.append("DOORLOOPTIJD")
    # Remove everything that contains "opname"
    toBeRemoved.append("opname")
    # Remove everything that contains "frequentie_contact"
    toBeRemoved.append("frequentie_contact")
    # Remove everything that contains "gebruik_covid"
    toBeRemoved.append("gebruik_covid")
    # Remove everything that contains "F1_IC"
    toBeRemoved.append("F1_IC")
    # Remove everything that contains "KLACHTEN"
    toBeRemoved.append("KLACHTEN")
    # Remove everything that contains "FL_LC"
    toBeRemoved.append("FL_LC")
    # Remove everything that contains "F1_LONGCOVID"
    toBeRemoved.append("F1_LONGCOVID")
    # Remove everything that contains "F1_MEDICATIEGEBRUIK"
    toBeRemoved.append("F1_MEDICATIEGEBRUIK")
    # Remove everything that contains "PRAATGROEP_COVID"
    toBeRemoved.append("PRAATGROEP_COVID")
    # Remove everything that contains "F1_REDEN_PROF_ZORG"
    toBeRemoved.append("F1_REDEN_PROF_ZORG")
    # Remove everything that contains "F1_VACCINATIE_SOORT"
    toBeRemoved.append("F1_VACCINATIE_SOORT")
    # Remove everything that contains "F1_ZUURSTOF"
    toBeRemoved.append("F1_ZUURSTOF")
    # Remove everything that contains "lengte", we have bmi
    toBeRemoved.append("lengte")
    # Remove everything that contains "IC_"
    toBeRemoved.append("IC_")
    # Remove everything that contains "LONGCOVID_"
    toBeRemoved.append("LONGCOVID_")
    # Remove everything that contains "mnd_sinds_pcr"
    toBeRemoved.append("mnd_sinds_pcr")
    # Remove everything that contains "NEG_LONGCOVID"
    toBeRemoved.append("NEG_LONGCOVID")
    # Remove a number of variables from gecco that indicate the age-population of an area (e.g. 65+)
    # Remove everything that contains "v1.1"
    toBeRemoved.append("v1.1")
    # Remove everything that contains "v1.2"
    toBeRemoved.append("v1.2")
    # Remove everything that contains "v1.4"
    toBeRemoved.append("v1.4")
    # Remove everything that contains "comorbidities"
    toBeRemoved.append("comorbidities")
    # Remove everything that contains "v1.6"
    toBeRemoved.append("v1.6")
    # Remove everything that contains "V16"
    toBeRemoved.append("V16")
    # Remove everything that contains "POS_LONGCOVID"
    toBeRemoved.append("POS_LONGCOVID")
    # Remove everything that contains "postcode"
    toBeRemoved.append("postcode")
    # Remove everything that contains "PROFESSIONELE_ZORG_COVIDTEST_NU"
    toBeRemoved.append("PROFESSIONELE_ZORG_COVIDTEST_NU")
    # Remove everything that contains "prop"
    toBeRemoved.append("prop")
    # Remove everything that contains "REDEN_PROF_ZORG"
    toBeRemoved.append("REDEN_PROF_ZORG")
    # Remove everything that contains "strain"
    toBeRemoved.append("strain")
    # Remove everything that contains "vac1_dat_dich"
    toBeRemoved.append("dat_dich")
    return toBeRemoved


def selectAttributesToBeRemoved():
    toBeRemoved = []

    # Remove BMI, we have bmi_cat
    toBeRemoved.append('BMI')
    # Remove booster variants, we have booster
    toBeRemoved.append('boostervaccinatie_recoded')
    toBeRemoved.append( 'boostervaccinatie')
    toBeRemoved.append('booster_wil_niet_zeggen')
    # Remove check_vac_soort
    toBeRemoved.append('check_vac_soort')
    # Remove DEPRESSIE_1_Re, DEPRESSIE_2_Re, DEPRESSIE_3_Re, DEPRESSIE_4_Re, DEPRESSIE_5_Re, DEPRESSIE_6_Re, DEPRESSIE_7_Re, DEPRESSIE_8_Re, DEPRESSIE_9_Re
    toBeRemoved.append('DEPRESSIE_1_Re')
    toBeRemoved.append('DEPRESSIE_2_Re')
    toBeRemoved.append('DEPRESSIE_3_Re')
    toBeRemoved.append('DEPRESSIE_4_Re')
    toBeRemoved.append('DEPRESSIE_5_Re')
    toBeRemoved.append('DEPRESSIE_6_Re')
    toBeRemoved.append('DEPRESSIE_7_Re')
    toBeRemoved.append('DEPRESSIE_8_Re')
    toBeRemoved.append('DEPRESSIE_9_Re')
    # Remove excluderen
    toBeRemoved.append('excluderen')
    # Remove F1_DEELNAME_BASELINE
    toBeRemoved.append('F1_DEELNAME_BASELINE')
    # Remove diversity_type_N_extra, we have diversity_type_N
    toBeRemoved.append('diversity_type_N_extra')
    # Remove F1_HERSTELD_NU
    toBeRemoved.append('F1_HERSTELD_NU')
    # Remove F1_leeftijd_60_min_plus
    toBeRemoved.append('F1_leeftijd_60_min_plus')
    # Remove F1_NIEUWE_OPLEIDING
    toBeRemoved.append('F1_NIEUWE_OPLEIDING')
    # Remove F1_OOIT_COVID_GEHAD
    toBeRemoved.append('F1_OOIT_COVID_GEHAD')
    # Remove F1_pos_test
    toBeRemoved.append('F1_pos_test')
    # Remove F1_REFERRER
    toBeRemoved.append('F1_REFERRER')
    # Remove F1_totaal_aantal_pos_tests
    toBeRemoved.append('F1_totaal_aantal_pos_tests')
    # Remove F1_TWEEDE_BOOSTER_MERK
    toBeRemoved.append('F1_TWEEDE_BOOSTER_MERK')
    # Remove fam
    toBeRemoved.append('fam')
    # Remove filter_$
    toBeRemoved.append('filter_$')
    # Remove filter_network
    toBeRemoved.append('filter_network')
    # Remove gedurende2020
    toBeRemoved.append('gedurende2020')
    # Remove GESLACHT
    toBeRemoved.append('GESLACHT')
    # Remove GESLACHT_JUIST
    toBeRemoved.append('GESLACHT_JUIST')
    # Remove geslacht_leeftijd_juist
    toBeRemoved.append('geslacht_leeftijd_juist')
    # Remove geslacht_totaal_iedereen
    toBeRemoved.append('geslacht_totaal_iedereen')
    # Remove GEWICHT, we have bmi
    toBeRemoved.append('GEWICHT')
    # Remove GROEP
    toBeRemoved.append('GROEP')
    # Remove HERSTELD_NU
    toBeRemoved.append('HERSTELD_NU')
    # Remove LC_who_totaal
    toBeRemoved.append('LC_who_totaal')
    # Remove only leave leeftijd_totaal
    toBeRemoved.append('leeftijd')
    toBeRemoved.append('leeftijd_60_min_plus')
    toBeRemoved.append('LEEFTIJD_JUIST_2')
    toBeRemoved.append('LEEFTIJDSCAT_2')
    # Remove positief_CoronIT_negatief_vragenlijst, POSITIEF_GETEST, positief_vragenlijst_negatief_CoronIT
    toBeRemoved.append('positief_CoronIT_negatief_vragenlijst')
    toBeRemoved.append('POSITIEF_GETEST')
    toBeRemoved.append('positief_vragenlijst_negatief_CoronIT')
    # Remove REFERRER
    toBeRemoved.append('REFERRER')
    # Remove same_sex_incl_care
    toBeRemoved.append('same_sex_incl_care')
    # Remove sex_network_members
    toBeRemoved.append('sex_network_members')
    # Remove total_contact
    toBeRemoved.append('total_contact')
    # Remove UITSLAG_KOPPELING 'uitslag_totaal'
    toBeRemoved.append('UITSLAG_KOPPELING')
    toBeRemoved.append('uitslag_totaal')
    # Remove urbanization we hebben urbanization_cat
    toBeRemoved.append('urbanization')
    # Remove vaccinatie_sinds_vorige_vragenlijst, 'VACCINATIE_SOORT_1', 'VACCINATIE_SOORT_2', 'vaccinatiestatus_gecombineerd_1'
    toBeRemoved.append('vaccinatie_sinds_vorige_vragenlijst')
    toBeRemoved.append('VACCINATIE_SOORT_1')
    toBeRemoved.append('VACCINATIE_SOORT_2')
    toBeRemoved.append('vaccinatiestatus_gecombineerd_1')
    # Remove variant
    toBeRemoved.append('variant')
    # Remove VERSCHIL_LEEFTIJDSCAT
    toBeRemoved.append('VERSCHIL_LEEFTIJDSCAT')
    # Remove voor1945
    toBeRemoved.append('voor1945')
    # Remove ZUURSTOF
    toBeRemoved.append('ZUURSTOF')
    return toBeRemoved

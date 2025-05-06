import preprocessing


def selectPatternsToBeRemoved():
    toBeRemoved = []
    # Remove everything that contains "@", unknown help attributes, so removed
    toBeRemoved.append("@")
    # Remove everything that contains "AANTAL_DAGEN", "AANTAL_WEKEN", "AANTAL_UREN", indicates how many days/hours/week a person recieved help. First try with a simple "got help" attribute
    toBeRemoved.append("AANTAL_DAGEN")
    toBeRemoved.append("AANTAL_WEKEN")
    toBeRemoved.append("AANTAL_UREN")
    toBeRemoved.append("LIGGEN_TIJD")
    toBeRemoved.append("F1_LICHAMELIJK")
    toBeRemoved.append("LICHTHOOFDIGHEID")
    toBeRemoved.append("NACHTEN_IN_ZIEKENHUIS")
    toBeRemoved.append("POSITIEVE_GEZONDHEID")
    toBeRemoved.append("PRODUCTIVITEIT")
    toBeRemoved.append("RECHTOPSTAAN")
    toBeRemoved.append("ROL_PRAATGROEP")
    toBeRemoved.append("WAZIG_ZIEN_OF_KOKERZICHT_NA_STAAN")
    toBeRemoved.append("LYING")
    toBeRemoved.append("V37")
    toBeRemoved.append("SNELLE_HARTSLAG_NA_STAAN")
    # Remove sociale_steun, individual questions could be interesting, but not all at once
    # is there no mean score for this?
    toBeRemoved.append("SOCIALE_STEUN")
    # Remove stress, individual questions could be interesting, but not all at once
    # is there no mean score for this?
    toBeRemoved.append("F1_STRESS")
    # Remove F1_TOEGANG_TOT_GEZONDHEIDSINFORMATIE, individual questions could be interesting, but not all at once
    # is there no mean score for this?
    toBeRemoved.append("F1_TOEGANG_TOT_GEZONDHEIDSINFORMATIE_")
    # Remove F1_VERMOEIDHEID, individual questions could be interesting, but not all at once
    # is there no mean score for this?
    toBeRemoved.append("F1_VERMOEIDHEID_")
    toBeRemoved.append("TRAUMA")
    # Remove geboorteland, there are a number of achtergrond attributes
    toBeRemoved.append("GEBOORTELAND")
    toBeRemoved.append("F1_UREN")
    toBeRemoved.append("TOESTEMMING_ANDER_ONDERZOEK")
    toBeRemoved.append("MATE")
    toBeRemoved.append("MATIGE_ACTIVITEIT_TIJD")
    # Remove everything that contains "bewustzijn", attributes regarding awareness that they had covid or not
    toBeRemoved.append("bewustzijn")
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
    # Remove everything that contains "EENZAAM_CORONA"
    toBeRemoved.append("EENZAAM_CORONA")
    # Remove everything that contains "ANGSTIG_SOMBER"
    toBeRemoved.append("ANGSTIG_SOMBER")
    # Remove everything that contains "ROND_TEST", attributes that specify if complaints start before/after
    # # Covid test. Don't care for our context
    toBeRemoved.append("ROND_TEST")
    # Remove everything that contains "Diff_days"
    toBeRemoved.append("Diff_days")
    # Remove everything that contains "Diff_months"
    toBeRemoved.append("Diff_months")
    # Remove everything that contains "Diff_weeks"
    toBeRemoved.append("Diff_weeks")
    # Remove everything that contains "admission"
    toBeRemoved.append("admission")
    # Remove everything that contains "symp", don't care about covid symptoms for network analysis
    toBeRemoved.append("symp")
    # Remove everything that contains "C_OXYGEN_USE"
    toBeRemoved.append("C_OXYGEN_USE")
    # Remove everything that contains "severity_covid"
    toBeRemoved.append("severity_covid")
    # Remove everything that contains "GEESTELIJKE_VERMOEIDHEID_NA_INSPANNING"
    toBeRemoved.append("GEESTELIJKE_VERMOEIDHEID_NA_INSPANNING")
    # Remove everything that contains "GEZONDHEID_CIJFER_NU"
    toBeRemoved.append("GEZONDHEID_CIJFER_NU")
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
    # Remove everything that contains "coping"
    toBeRemoved.append("coping")
    # Remove everything that contains "covid_test"
    toBeRemoved.append("covid_test")
    # Remove everything that contains "DEPRESSIE_", we want total scores if anything
    toBeRemoved.append("DEPRESSIE_")
    # Remove everything that contains "DOORLOOPTIJD"
    toBeRemoved.append("DOORLOOPTIJD")
    # Remove everything that contains "EENZAAMHEID_, we want total scores
    toBeRemoved.append("EENZAAMHEID_")
    # Remove everything that contains "emotional_total_, unclear what this is
    toBeRemoved.append("emotional_total_")
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
    # Remove everything that contains "kortademigheid"
    toBeRemoved.append("kortademigheid")
    # Remove everything that contains "OPEN"
    toBeRemoved.append("OPEN")
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
    # Remove everything that contains "AFWEZIG_WERK_ZIEKTE"
    toBeRemoved.append("AFWEZIG_WERK_ZIEKTE")
    # Remove everything that contains "PROFESSIONELE_ZORG_COVIDTEST_NU"
    toBeRemoved.append("PROFESSIONELE_ZORG_COVIDTEST_NU")
    # Remove everything that contains "DOOF_EN_ZWAAR_GEVOEL_NA_INSPANNING"
    toBeRemoved.append("DOOF_EN_ZWAAR_GEVOEL_NA_INSPANNING")
    # Remove everything that contains "prop"
    toBeRemoved.append("prop")
    # Remove everything that contains "REDEN_PROF_ZORG"
    toBeRemoved.append("REDEN_PROF_ZORG")
    # Remove everything that contains "ROOK_Product", don't care about the product
    toBeRemoved.append("ROOK_Product")
    # Remove everything that contains "strain"
    toBeRemoved.append("strain")
    # Remove everything that contains "welke_clubs", might be interesting in the future, but let's start with just club membership in general
    toBeRemoved.append("welke_clubs")
    # Remove everything that contains "wandelen"
    toBeRemoved.append("wandelen")
    # Remove everything that contains "vac1_dat_dich"
    toBeRemoved.append("dat_dich")
    # Remove everything that contains "r.1", this appears to be a set of copied attributes
    toBeRemoved.append("r.1")
    # Remove everything that contains "ZWARE_ACTIVITEIT_TIJD"
    toBeRemoved.append("ZWARE_ACTIVITEIT_TIJD")
    # Remove everything that contains "ZITTEN"
    toBeRemoved.append("ZITTEN")
    return toBeRemoved


def selectAttributesToBeRemoved():
    toBeRemoved = []
    # Remove ACTUAL_STUDYHOURS
    toBeRemoved.append('ACTUAL_STUDYHOURS')
    # Remove ACTUAL_WORKHOURS
    toBeRemoved.append('ACTUAL_WORKHOURS')
    # Remove C_OPLEIDINGSNIVEAU_ISCED
    toBeRemoved.append('C_OPLEIDINGSNIVEAU_ISCED')
    # Remove CIS_FATIGUE_TOTAL
    toBeRemoved.append('CIS_FATIGUE_TOTAL')
    # Remove difficult_relationship_total
    toBeRemoved.append('difficult_relationship_total')
    # Remove emotional_support_total
    toBeRemoved.append('emotional_support_total')
    # Remove BMI, we have bmi_cat
    toBeRemoved.append('BMI')
    # Remove booster variants, we have booster
    toBeRemoved.append('boostervaccinatie_recoded')
    toBeRemoved.append( 'boostervaccinatie')
    toBeRemoved.append('booster_wil_niet_zeggen')
    # Remove check_vac_soort
    toBeRemoved.append('check_vac_soort')
    # Remove excluderen
    toBeRemoved.append('excluderen')
    # Remove F1_DEELNAME_BASELINE
    toBeRemoved.append('F1_DEELNAME_BASELINE')
    # Remove F1_GEZONDHEID_ALGEMEEN_3MND
    toBeRemoved.append('F1_GEZONDHEID_ALGEMEEN_3MND')
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
    # Remove F1_GEZONDHEID_INFORMATIE_1, we hebben een mean score
    toBeRemoved.append('F1_GEZONDHEID_INFORMATIE_1')
    # Remove F1_GEZONDHEID_INFORMATIE_2,  we hebben een mean score
    toBeRemoved.append('F1_GEZONDHEID_INFORMATIE_2')
    # Remove F1_GEZONDHEID_INFORMATIE_3,  we hebben een mean score
    toBeRemoved.append('F1_GEZONDHEID_INFORMATIE_3')
    # Remove F1_GEZONDHEID_INFORMATIE_4,  we hebben een mean score
    toBeRemoved.append('F1_GEZONDHEID_INFORMATIE_4')
    # Remove JUISTE_ZORG_KRIJGEN_1,  we hebben een mean score
    toBeRemoved.append('F1_JUISTE_ZORG_KRIJGEN_1')
    # Remove F1_JUISTE_ZORG_KRIJGEN_2,  we hebben een mean score
    toBeRemoved.append('F1_JUISTE_ZORG_KRIJGEN_2')
    # Remove F1_JUISTE_ZORG_KRIJGEN_3,  we hebben een mean score
    toBeRemoved.append('F1_JUISTE_ZORG_KRIJGEN_3')
    # Remove F1_JUISTE_ZORG_KRIJGEN_4,  we hebben een mean score
    toBeRemoved.append('F1_JUISTE_ZORG_KRIJGEN_4')
    # Remove F1_JUISTE_ZORG_KRIJGEN_5,  we hebben een mean score
    toBeRemoved.append('F1_JUISTE_ZORG_KRIJGEN_5')
    # Remove F1_JUISTE_ZORG_KRIJGEN_6,  we hebben een mean score
    toBeRemoved.append('F1_JUISTE_ZORG_KRIJGEN_6')
    # Remove F1_STEUN_VAN_OMGEVING_1,  we hebben een mean score
    toBeRemoved.append('F1_STEUN_VAN_OMGEVING_1')
    # Remove F1_STEUN_VAN_OMGEVING_2,  we hebben een mean score
    toBeRemoved.append('F1_STEUN_VAN_OMGEVING_2')
    # Remove F1_STEUN_VAN_OMGEVING_3,  we hebben een mean score
    toBeRemoved.append('F1_STEUN_VAN_OMGEVING_3')
    # Remove F1_STEUN_VAN_OMGEVING_4,  we hebben een mean score
    toBeRemoved.append('F1_STEUN_VAN_OMGEVING_4')
    # Remove F1_STEUN_VAN_OMGEVING_5,  we hebben een mean score
    toBeRemoved.append('F1_STEUN_VAN_OMGEVING_5')
    # Remove F1_EERSTE_BOOSTER_MERK
    toBeRemoved.append('F1_EERSTE_BOOSTER_MERK')
    # Remove F1_GEZONDHEID_NU_CBS
    toBeRemoved.append('F1_GEZONDHEID_NU_CBS')
    # Remove F1_Groep, onduidelijk waar dit voor dient
    toBeRemoved.append('F1_GROEP')
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
    # Remove geslacht_totaal_iedereen
    toBeRemoved.append('geslacht_totaal_iedereen')
    # Remove geslacht_leeftijd_juist
    toBeRemoved.append('geslacht_leeftijd_juist')
    # Remove F1_WERK_AFWEZIG
    toBeRemoved.append('F1_WERK_AFWEZIG')
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
    # Remove werksector
    toBeRemoved.append('werksector')
    # Remove WERKSITUATIE
    toBeRemoved.append('WERKSITUATIE_REFINED')
    # Remove ZUURSTOF
    toBeRemoved.append('ZUURSTOF')
    return toBeRemoved

def selectRadiusAttributes(areaOfInterest, data):
    if areaOfInterest == 'dichstbijzijnde':
        return ['aantalbinnen']

    # else find the correct distance to keep:
    distances = [col for col in data.columns if 'aantalbinnen' in col]
    grouped_data = {}

    for item in distances:
        # Split at "aantalbinnen"
        prefix, distance = item.split("aantalbinnen")

        # Remove "km" and convert to integer
        distance_int = int(distance.replace("km", ""))

        # Add to dictionary with full name
        if prefix not in grouped_data:
            grouped_data[prefix] = []

        grouped_data[prefix].append((distance_int, item))  # Store as tuple (distance, original name)

    # Find the middle option for each prefix
    toBeRemoved = []
    for key, values in grouped_data.items():
        values.sort()  # Sort by numeric distance
        middle_index = len(values) // 2
        largest_index = len(values)-1# Find middle index

        if areaOfInterest == 'closests':
            toBeRemoved.append(values[middle_index][1])
            toBeRemoved.append(values[largest_index][1])
        elif areaOfInterest == 'middle':
            toBeRemoved.append(values[0][1])
            toBeRemoved.append(values[largest_index][1])
        elif areaOfInterest == 'furthest':
            toBeRemoved.append(values[0][1])
            toBeRemoved.append(values[middle_index][1])

    return toBeRemoved

def selectGeslacht(data):
    geslacht_cols = [col for col in data.columns if (("geslacht" in col) and not("geslacht_totaal" in col))]
    return preprocessing.removeAttributes(data, geslacht_cols)

def selectWalkability(data, variant, radius):
    # possible radiusses:
    # 150, 250, 350, 500, 750, 1000, 1650, 2000, 3000
    selected = [col for col in data.columns if (("Walkability."+variant in col) and not(radius in col))]
    return preprocessing.removeAttributes(data, selected)

def selectGreenspace(data, variant, radius):
    # possible radiusses:
    # 500, 1000, 1500
    # variants: all or high
    selected = [col for col in data.columns if (("Greenspace" in col) and (not(radius + "m_"+variant in col)))]
    return preprocessing.removeAttributes(data, selected)

def selectSupportLevels(data, include, supporttype):
    # possible supprots:
    # acquaintances, caregivers, extra, family, friends, incl_care
    # if include is left empty, every level is deleted
    supports = [col for col in data.columns if ((supporttype in col))]
    selected = []
    for s in supports:
        for i in include:
            if i in s:
                selected.append(s)
    for s in selected:
        supports.remove(s)

    return preprocessing.removeAttributes(data, supports)

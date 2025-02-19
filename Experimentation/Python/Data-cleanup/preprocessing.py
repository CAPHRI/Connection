import pandas

# Support function to merge multiple multiply exclusive binary attributes into 1 attribute
# e.g. is_man, is_female, is_other into gender {is_man, is_female, is_other}
def mergeBinary(list, newName, data):
    data[newName] = data[list].replace("?", 0).apply(lambda row: ', '.join(row.index[row == 1]), axis=1)
    data = data.drop(columns=list)
    return data

data = pandas.read_csv('resources/clean/BL1_FU1.csv')

print(data.shape)

# Remove everything that contains "@", unknown help attributes, so removed
data = data.loc[:, ~data.columns.str.contains("@", case=False)]
# Remove everything that contains "ANDERE_VOLWASSENE_ZELFDE_EMAIL"
data = data.loc[:, ~data.columns.str.contains("ANDERE_VOLWASSENE_ZELFDE_EMAIL", case=False)]
# Remove everything that contains "sindstest", attributes that specify if complaints start before/after
# Covid test. Don't care for our context
data = data.loc[:, ~data.columns.str.contains("sindstest", case=False)]
# Remove everything that contains "voortest", attributes that specify if complaints start before/after
# # Covid test. Don't care for our context
data = data.loc[:, ~data.columns.str.contains("voortest", case=False)]
# Remove "aantal_vac_voor_test"
data = data.loc[:, ~data.columns.str.contains("aantal_vac_voor_test", case=False)]
# Remove everything that contains "age_"
data = data.loc[:, ~data.columns.str.contains("age_", case=False)]
# Remove everything that contains "ANTISTOFFEN"
data = data.loc[:, ~data.columns.str.contains("ANTISTOFFEN", case=False)]
# Remove everything that contains "ROND_TEST", attributes that specify if complaints start before/after
# # Covid test. Don't care for our context
data = data.loc[:, ~data.columns.str.contains("ROND_TEST", case=False)]
# Remove BMI, we have bmi_cat
data = data.drop(columns=['BMI'])
# Remove booster variants, we have booster
data = data.drop(columns=['boostervaccinatie_recoded', 'boostervaccinatie', 'booster_wil_niet_zeggen'])
# Remove everything that contains "Diff_days"
data = data.loc[:, ~data.columns.str.contains("Diff_days", case=False)]
# Remove everything that contains "admission"
data = data.loc[:, ~data.columns.str.contains("admission", case=False)]
# Remove everything that contains "symp", don't care about covid symptoms for network analysis
data = data.loc[:, ~data.columns.str.contains("symp", case=False)]
# Remove everything that contains "C_OXYGEN_USE"
data = data.loc[:, ~data.columns.str.contains("C_OXYGEN_USE", case=False)]
# Remove everything that contains "severity_covid"
data = data.loc[:, ~data.columns.str.contains("severity_covid", case=False)]
# Remove check_vac_soort
data = data.drop(columns=['check_vac_soort'])
# Remove everything that contains "jaar"
data = data.loc[:, ~data.columns.str.contains("jaar", case=False)]
# Remove everything that contains "kwartaal"
data = data.loc[:, ~data.columns.str.contains("kwartaal", case=False)]
# Remove everything that contains "maand"
data = data.loc[:, ~data.columns.str.contains("maand", case=False)]
# Remove everything that contains "compleet"
data = data.loc[:, ~data.columns.str.contains("compleet", case=False)]
# Remove everything that contains "contact_"
data = data.loc[:, ~data.columns.str.contains("contact_", case=False)]
# Remove everything that contains "controle"
data = data.loc[:, ~data.columns.str.contains("controle", case=False)]
# Remove everything that contains "covid_test"
data = data.loc[:, ~data.columns.str.contains("covid_test", case=False)]
# Remove DEPRESSIE_1_Re, DEPRESSIE_2_Re, DEPRESSIE_3_Re, DEPRESSIE_4_Re, DEPRESSIE_5_Re, DEPRESSIE_6_Re, DEPRESSIE_7_Re, DEPRESSIE_8_Re, DEPRESSIE_9_Re
data = data.drop(columns=['DEPRESSIE_1_Re', 'DEPRESSIE_2_Re', 'DEPRESSIE_3_Re', 'DEPRESSIE_4_Re', 'DEPRESSIE_5_Re', 'DEPRESSIE_6_Re', 'DEPRESSIE_7_Re', 'DEPRESSIE_8_Re', 'DEPRESSIE_9_Re'])
# Remove everything that contains "DOORLOOPTIJD"
data = data.loc[:, ~data.columns.str.contains("DOORLOOPTIJD", case=False)]
# Remove ELIGIBLEcases_longcovid_calc
data = data.drop(columns=['ELIGIBLEcases_longcovid_calc'])
# Remove excluderen
data = data.drop(columns=['excluderen'])
# Remove F1_DEELNAME_BASELINE
data = data.drop(columns=['F1_DEELNAME_BASELINE'])
# Remove diversity_type_N_extra, we have diversity_type_N
data = data.drop(columns=['diversity_type_N_extra'])
# Remove everything that contains "opname"
data = data.loc[:, ~data.columns.str.contains("opname", case=False)]
# Remove everything that contains "frequentie_contact"
data = data.loc[:, ~data.columns.str.contains("frequentie_contact", case=False)]
# Remove everything that contains "gebruik_covid"
data = data.loc[:, ~data.columns.str.contains("gebruik_covid", case=False)]
# Remove F1_HERSTELD_NU
data = data.drop(columns=['F1_HERSTELD_NU'])
# Remove everything that contains "F1_IC"
data = data.loc[:, ~data.columns.str.contains("F1_IC", case=False)]
# Remove everything that contains "KLACHTEN"
data = data.loc[:, ~data.columns.str.contains("KLACHTEN", case=False)]
# Remove everything that contains "FL_LC"
data = data.loc[:, ~data.columns.str.contains("FL_LC", case=False)]
# Remove F1_leeftijd_60_min_plus
data = data.drop(columns=['F1_leeftijd_60_min_plus'])
# Remove everything that contains "F1_LONGCOVID"
data = data.loc[:, ~data.columns.str.contains("F1_LONGCOVID", case=False)]
# Remove everything that contains "F1_MEDICATIEGEBRUIK"
data = data.loc[:, ~data.columns.str.contains("F1_MEDICATIEGEBRUIK", case=False)]
# Remove F1_NIEUWE_OPLEIDING
data = data.drop(columns=['F1_NIEUWE_OPLEIDING'])
# Remove F1_OOIT_COVID_GEHAD
data = data.drop(columns=['F1_OOIT_COVID_GEHAD'])
# Remove F1_POS_LONGCOVID_NOW_V1
data = data.drop(columns=['F1_POS_LONGCOVID_NOW_V1'])
# Remove F1_pos_test
data = data.drop(columns=['F1_pos_test'])
# Remove everything that contains "PRAATGROEP_COVID"
data = data.loc[:, ~data.columns.str.contains("PRAATGROEP_COVID", case=False)]
# Remove everything that contains "F1_REDEN_PROF_ZORG"
data = data.loc[:, ~data.columns.str.contains("F1_REDEN_PROF_ZORG", case=False)]
# Remove F1_REFERRER
data = data.drop(columns=['F1_REFERRER'])
# Remove F1_totaal_aantal_pos_tests
data = data.drop(columns=['F1_totaal_aantal_pos_tests'])
# Remove F1_TWEEDE_BOOSTER_MERK
data = data.drop(columns=['F1_TWEEDE_BOOSTER_MERK'])
# Remove everything that contains "F1_VACCINATIE_SOORT"
data = data.loc[:, ~data.columns.str.contains("F1_VACCINATIE_SOORT", case=False)]
# Remove everything that contains "F1_ZUURSTOF"
data = data.loc[:, ~data.columns.str.contains("F1_ZUURSTOF", case=False)]
# Remove fam
data = data.drop(columns=['fam'])
# Remove filter_$
data = data.drop(columns=['filter_$'])
# Remove filter_network
data = data.drop(columns=['filter_network'])
# Remove gedurende2020
data = data.drop(columns=['gedurende2020'])
# Remove GESLACHT
data = data.drop(columns=['GESLACHT'])
# Remove GESLACHT_JUIST
data = data.drop(columns=['GESLACHT_JUIST'])
# Remove geslacht_leeftijd_juist
data = data.drop(columns=['geslacht_leeftijd_juist'])
# Remove geslacht_totaal_iedereen
data = data.drop(columns=['geslacht_totaal_iedereen'])
# Remove GEWICHT, we have bmi
data = data.drop(columns=['GEWICHT'])
# Remove everything that contains "lengte", we have bmi
data = data.loc[:, ~data.columns.str.contains("lengte", case=False)]
# Remove GROEP
data = data.drop(columns=['GROEP'])
# Remove HERSTELD_NU
data = data.drop(columns=['HERSTELD_NU'])
# Remove everything that contains "IC_"
data = data.loc[:, ~data.columns.str.contains("IC_", case=False)]
# Remove LC_who_totaal
data = data.drop(columns=['LC_who_totaal'])
# Remove only leave leeftijd_totaal
data = data.drop(columns=['leeftijd', 'leeftijd_60_min_plus', 'LEEFTIJD_JUIST_2', 'LEEFTIJDSCAT_2'])
# Remove everything that contains "LONGCOVID_"
data = data.loc[:, ~data.columns.str.contains("LONGCOVID_", case=False)]
# Remove everything that contains "mnd_sinds_pcr"
data = data.loc[:, ~data.columns.str.contains("mnd_sinds_pcr", case=False)]
# Remove everything that contains "NEG_LONGCOVID"
data = data.loc[:, ~data.columns.str.contains("NEG_LONGCOVID", case=False)]
# Remove a number of variables from gecco that indicate the age-population of an area (e.g. 65+)
# Remove everything that contains "v1.1"
data = data.loc[:, ~data.columns.str.contains("v1.1", case=False)]
# Remove everything that contains "v1.2"
data = data.loc[:, ~data.columns.str.contains("v1.2", case=False)]
# Remove everything that contains "v1.4"
data = data.loc[:, ~data.columns.str.contains("v1.4", case=False)]
# Remove everything that contains "comorbidities"
data = data.loc[:, ~data.columns.str.contains("comorbidities", case=False)]
# Remove everything that contains "v1.6"
data = data.loc[:, ~data.columns.str.contains("v1.6", case=False)]
# Remove everything that contains "V16"
data = data.loc[:, ~data.columns.str.contains("V16", case=False)]
# Remove everything that contains "POS_LONGCOVID"
data = data.loc[:, ~data.columns.str.contains("POS_LONGCOVID", case=False)]
# Remove positief_CoronIT_negatief_vragenlijst, POSITIEF_GETEST, positief_vragenlijst_negatief_CoronIT
data = data.drop(columns=['positief_CoronIT_negatief_vragenlijst', 'POSITIEF_GETEST', 'positief_vragenlijst_negatief_CoronIT'])
# Remove everything that contains "postcode"
data = data.loc[:, ~data.columns.str.contains("postcode", case=False)]
# Remove everything that contains "PROFESSIONELE_ZORG_COVIDTEST_NU"
data = data.loc[:, ~data.columns.str.contains("PROFESSIONELE_ZORG_COVIDTEST_NU", case=False)]
# Remove everything that contains "prop"
data = data.loc[:, ~data.columns.str.contains("prop", case=False)]
# Remove everything that contains "REDEN_PROF_ZORG"
data = data.loc[:, ~data.columns.str.contains("REDEN_PROF_ZORG", case=False)]
# Remove REFERRER
data = data.drop(columns=['REFERRER'])
# Remove same_sex_incl_care
data = data.drop(columns=['same_sex_incl_care'])
# Remove sex_network_members
data = data.drop(columns=['sex_network_members'])
# Remove everything that contains "strain"
data = data.loc[:, ~data.columns.str.contains("strain", case=False)]
# Remove total_contact
data = data.drop(columns=['total_contact'])
# Remove UITSLAG_KOPPELING 'uitslag_totaal'
data = data.drop(columns=['UITSLAG_KOPPELING','uitslag_totaal'])
# Remove urbanization we hebben urbanization_cat
data = data.drop(columns=['urbanization'])
# Remove everything that contains "vac1_dat_dich"
data = data.loc[:, ~data.columns.str.contains("dat_dich", case=False)]
# Remove vaccinatie_sinds_vorige_vragenlijst, 'VACCINATIE_SOORT_1', 'VACCINATIE_SOORT_2', 'vaccinatiestatus_gecombineerd_1'
data = data.drop(columns=['vaccinatie_sinds_vorige_vragenlijst', 'VACCINATIE_SOORT_1', 'VACCINATIE_SOORT_2', 'vaccinatiestatus_gecombineerd_1'])
# Remove variant
data = data.drop(columns=['variant'])
# Remove VERSCHIL_LEEFTIJDSCAT
data = data.drop(columns=['VERSCHIL_LEEFTIJDSCAT'])
# Remove voor1945
data = data.drop(columns=['voor1945'])
# Remove ZUURSTOF
data = data.drop(columns=['ZUURSTOF'])

#  Merge booster into 1 attribute
binary_cols = ['F1_BOOSTER_A1', 'F1_BOOSTER_A2', 'F1_BOOSTER_A3', 'F1_BOOSTER_A4']
data = mergeBinary(binary_cols, "F1_booster", data)

#  Merge opleiding into 1 attribute
binary_cols = ['F1_OPLEIDING_A1', 'F1_OPLEIDING_A2', 'F1_OPLEIDING_A3', 'F1_OPLEIDING_A4', 'F1_OPLEIDING_A5', 'F1_OPLEIDING_A6', 'F1_OPLEIDING_A7']
data = mergeBinary(binary_cols, "F1_OPLEIDING", data)

#  Merge vaccinatie into 1 attribute
binary_cols = ['F1_VACCINATIE_A1', 'F1_VACCINATIE_A2', 'F1_VACCINATIE_A3', 'F1_VACCINATIE_A4']
data = mergeBinary(binary_cols, "F1_vaccinatie", data)

#  Merge afdelingen into 1 attribute
binary_cols = ['F1_AFDELING_ZIEKENHUIS_A1', 'F1_AFDELING_ZIEKENHUIS_A2', 'F1_AFDELING_ZIEKENHUIS_A3', 'F1_AFDELING_ZIEKENHUIS_A4', 'F1_AFDELING_ZIEKENHUIS_A5', 'F1_AFDELING_ZIEKENHUIS_A6', 'F1_AFDELING_ZIEKENHUIS_A7']  # Explicitly define the columns to merge
data = mergeBinary(binary_cols, "afdeling_ziekenhuis", data)

print(data.shape)

# Save as proper csv file
data.to_csv("resources/clean/BL1_FU1_cleaned.csv",index=False, sep="," )
# Save as NL formating
data.to_csv("resources/clean/BL1_FU1_cleaned_NL_formatting.csv",index=False, sep=";" )


import pandas


def mergeBinary(list, newName, data):
    data[newName] = data[list].replace("?", 0).apply(lambda row: ', '.join(row.index[row == 1]), axis=1)
    data = data.drop(columns=list)
    return data

data = pandas.read_csv('resources/clean/BL1_FU1.csv')

print(data.shape)

# Remove everything that contains "ANDERE_VOLWASSENE_ZELFDE_EMAIL"
data = data.loc[:, ~data.columns.str.contains("ANDERE_VOLWASSENE_ZELFDE_EMAIL", case=False)]
# Remove everything that contains "V16"
data = data.loc[:, ~data.columns.str.contains("V16", case=False)]

# Remove everything that contains "VOORTEST"
data = data.loc[:, ~data.columns.str.contains("VOORTEST", case=False)]
# Remove everything that contains "voor_test"
data = data.loc[:, ~data.columns.str.contains("voor_test", case=False)]
# Remove everything that contains "SINDSTEST"
data = data.loc[:, ~data.columns.str.contains("SINDSTEST", case=False)]
# Remove everything that contains "ROND_TEST"
data = data.loc[:, ~data.columns.str.contains("ROND_TEST", case=False)]
# Remove everything that contains "ANDERE_VOLWASSENE_ZELFDE_EMAIL"
data = data.loc[:, ~data.columns.str.contains("ANDERE_VOLWASSENE_ZELFDE_EMAIL", case=False)]
# Remove everything that contains "Diff_Days"
data = data.loc[:, ~data.columns.str.contains("Diff_Days", case=False)]
# Remove everything that contains "ADMISSION"
data = data.loc[:, ~data.columns.str.contains("ADMISSION", case=False)]
# Remove everything that contains "SinceAfterTest"
data = data.loc[:, ~data.columns.str.contains("SinceAfterTest", case=False)]
# Remove everything that contains "SEVERITY"
data = data.loc[:, ~data.columns.str.contains("SEVERITY", case=False)]
# Remove everything that contains "jaar"
data = data.loc[:, ~data.columns.str.contains("jaar", case=False)]
# Remove everything that contains "maand"
data = data.loc[:, ~data.columns.str.contains("maand", case=False)]
# Remove everything that contains "kwartaal"
data = data.loc[:, ~data.columns.str.contains("kwartaal", case=False)]
# Remove everything that contains "compleet"
data = data.loc[:, ~data.columns.str.contains("compleet", case=False)]
# Remove everything that contains "TEST_GGD"
data = data.loc[:, ~data.columns.str.contains("TEST_GGD", case=False)]
# Remove everything that contains "datum"
data = data.loc[:, ~data.columns.str.contains("datum", case=False)]
# Remove everything that contains "DATUM"
data = data.loc[:, ~data.columns.str.contains("DATUM", case=False)]
# Remove everything that contains "DUUR_OPNAME"
data = data.loc[:, ~data.columns.str.contains("DUUR_OPNAME", case=False)]
# Remove everything that contains "longcovid_calc"
data = data.loc[:, ~data.columns.str.contains("longcovid_calc", case=False)]
# Remove everything that contains "excluderen"
data = data.loc[:, ~data.columns.str.contains("excluderen", case=False)]
# Remove everything that contains "BEHANDELING_ROND_TEST"
data = data.loc[:, ~data.columns.str.contains("BEHANDELING_ROND_TEST", case=False)]
# Remove everything that contains "BOOSTER"
data = data.loc[:, ~data.columns.str.contains("BOOSTER", case=False)]
# Remove everything that contains "C_Length_symptom"
data = data.loc[:, ~data.columns.str.contains("C_Length_symptom", case=False)]
# Remove everything that contains "Burden"
data = data.loc[:, ~data.columns.str.contains("Burden", case=False)]
# Remove everything that contains "DUUR"
data = data.loc[:, ~data.columns.str.contains("DUUR", case=False)]
# Remove everything that contains "Comborbidities"
data = data.loc[:, ~data.columns.str.contains("Comborbidities", case=False)]
# Remove everything that contains "CONTACT_MET_ZORG"
data = data.loc[:, ~data.columns.str.contains("CONTACT_MET_ZORG", case=False)]
# Remove everything that contains "DEELNAME_BASELINE"
data = data.loc[:, ~data.columns.str.contains("DEELNAME_BASELINE", case=False)]
# Remove everything that contains "Diff_Months"
data = data.loc[:, ~data.columns.str.contains("Diff_Months", case=False)]
# Remove everything that contains "EENZAAM_CORONA"
data = data.loc[:, ~data.columns.str.contains("EENZAAM_CORONA", case=False)]
# Remove everything that contains "GEBRUIK_COVID"
data = data.loc[:, ~data.columns.str.contains("GEBRUIK_COVID", case=False)]
# Remove everything that contains "HERSTELD_NU"
data = data.loc[:, ~data.columns.str.contains("HERSTELD_NU", case=False)]
# Remove everything that contains "F1_IC"
data = data.loc[:, ~data.columns.str.contains("F1_IC", case=False)]
# Remove everything that contains "CORONA_TEST"
data = data.loc[:, ~data.columns.str.contains("CORONA_TEST", case=False)]
# Remove everything that contains "proportion"
data = data.loc[:, ~data.columns.str.contains("proportion", case=False)]
# Remove everything that contains "WELKE_CLUBS"
data = data.loc[:, ~data.columns.str.contains("WELKE_CLUBS", case=False)]
# Remove everything that contains "REDEN_PROF_ZORG"
data = data.loc[:, ~data.columns.str.contains("REDEN_PROF_ZORG", case=False)]

# Merge arbeidsverleden
# Doesn't work cuz it's not binairy cuz reasons?
# binary_cols = ['ArbeidsverledenAfgelopen4jaarnietwerkzaam', 'ArbeidsverledenAfgelopen4jaarvoortdurendwerkzaam', 'ArbeidsverledenAfgelopen4jrnietvoortdurendwerkzaam', 'ArbeidsverledenGepensioneerd']  # Explicitly define the columns to merge
# data = mergeBinary(binary_cols, "arbeidsverleden", data)

binary_cols = ['F1_AFDELING_ZIEKENHUIS_A1', 'F1_AFDELING_ZIEKENHUIS_A2', 'F1_AFDELING_ZIEKENHUIS_A3', 'F1_AFDELING_ZIEKENHUIS_A4', 'F1_AFDELING_ZIEKENHUIS_A5', 'F1_AFDELING_ZIEKENHUIS_A6', 'F1_AFDELING_ZIEKENHUIS_A7']  # Explicitly define the columns to merge
data = mergeBinary(binary_cols, "afdeling_ziekenhuis", data)

print(data.shape)


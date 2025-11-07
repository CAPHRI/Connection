import pandas

source = "resources/LogRegCoefficients/baseline.csv"
baseline = pandas.read_csv(source)
source = "resources/LogRegCoefficients/beperktNetwerk.csv"
beperktNetwerk = pandas.read_csv(source)
source = "resources/LogRegCoefficients/GeenAandoeningen.csv"
geenAandoeningen = pandas.read_csv(source)
source = "resources/LogRegCoefficients/NoCareGivers.csv"
noCareGivers = pandas.read_csv(source)
source = "resources/LogRegCoefficients/NoDemographics.csv"
noDemographics = pandas.read_csv(source)
source = "resources/LogRegCoefficients/NoDemographicsNoLBM.csv"
noDemographicsNoLBM = pandas.read_csv(source)
source = "resources/LogRegCoefficients/NoLBM.csv"
noLBM = pandas.read_csv(source)
source = "resources/LogRegCoefficients/withDensity.csv"
withDensity = pandas.read_csv(source)

c = "five"
target = "resources/LogRegCoefficients/results/classes/class_" + c + ".csv"
target_dutch = "resources/LogRegCoefficients/results/classes/class_" + c + "_NL_Format.csv"

baseline_c = baseline[['Variable', c]].copy()
baseline_c = baseline_c.sort_values(c)
beperktNetwerk_c = beperktNetwerk[['Variable', c]].copy()
beperktNetwerk_c = beperktNetwerk_c.sort_values(c)
geenAandoeningen_c = geenAandoeningen[['Variable', c]].copy()
geenAandoeningen_c = geenAandoeningen_c.sort_values(c)
noCareGivers_c = noCareGivers[['Variable', c]].copy()
noCareGivers_c = noCareGivers_c.sort_values(c)
noDemographics_c = noDemographics[['Variable', c]].copy()
noDemographics_c = noDemographics_c.sort_values(c)
noDemographicsNoLBM_c = noDemographicsNoLBM[['Variable', c]].copy()
noDemographicsNoLBM_c = noDemographicsNoLBM_c.sort_values(c)
noLBM_c = noLBM[['Variable', c]].copy()
noLBM_c = noLBM_c.sort_values(c)
withDensity_c = withDensity[['Variable', c]].copy()
withDensity_c = withDensity_c.sort_values(c)

baseline_c = baseline_c.rename(columns={'Variable': 'Variable_baseline'})
beperktNetwerk_c = beperktNetwerk_c.rename(columns={'Variable': 'Variable_beperktNetwerk'})
geenAandoeningen_c = geenAandoeningen_c.rename(columns={'Variable': 'Variable_geenAandoeningen'})
noCareGivers_c = noCareGivers_c.rename(columns={'Variable': 'Variable_noCareGivers'})
noDemographics_c = noDemographics_c.rename(columns={'Variable': 'Variable_noDemographics'})
noDemographicsNoLBM_c = noDemographicsNoLBM_c.rename(columns={'Variable': 'Variable_noDemographicsNoLBM'})
noLBM_c = noLBM_c.rename(columns={'Variable': 'Variable_noLBM'})
withDensity_c = withDensity_c.rename(columns={'Variable': 'Variable_withDensity'})

baseline_c = baseline_c.rename(columns={c: c + '_baseline'})
beperktNetwerk_c = beperktNetwerk_c.rename(columns={c: c + '_beperktNetwerk'})
geenAandoeningen_c = geenAandoeningen_c.rename(columns={c: c + '_geenAandoeningen'})
noCareGivers_c = noCareGivers_c.rename(columns={c: c + '_noCareGivers'})
noDemographics_c = noDemographics_c.rename(columns={c: c + '_noDemographics'})
noDemographicsNoLBM_c = noDemographicsNoLBM_c.rename(columns={c: c + '_noDemographicsNoLBM'})
noLBM_c = noLBM_c.rename(columns={c: c + '_noLBM'})
withDensity_c = withDensity_c.rename(columns={c: c + '_withDensity'})

list = [baseline_c[-10:].reset_index(drop=True), beperktNetwerk_c[-10:].reset_index(drop=True),
        geenAandoeningen_c[-10:].reset_index(drop=True), noCareGivers_c[-10:].reset_index(drop=True),
        noDemographics_c[-10:].reset_index(drop=True), noDemographicsNoLBM_c[-10:].reset_index(drop=True),
        noLBM_c[-10:].reset_index(drop=True), withDensity_c[-10:].reset_index(drop=True)]

variables = []
for x in list:
        for y in x.columns:
                if "Variable" in y:
                        count = 0;
                        for z in x[y].tolist():
                                variables.append(str(count) + "_" + z)
                                # count+=1

variables = set(variables)
print(len(variables))
print(variables)

# combined = pandas.concat(list, axis = 1)
# combined.to_csv(target, index=False)
# combined.to_csv(target_dutch, sep=';', index=False)

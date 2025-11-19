import pandas
import numpy

models = ["baseline", "NoDemographics"]
data = pandas.read_csv("resources/LogRegCoefficients/NoDemographics.csv")
allowedAttributes = data["Variable"]
combined = {}
for model in models:

    source = "resources/LogRegCoefficients/"+ model +".csv"
    target = "resources/LogRegCoefficients/results/rankChange.csv"
    target_dutch = "resources/LogRegCoefficients/results/rankChange_NL_format.csv"
    targetAbsolute = "resources/LogRegCoefficients/results/rankChangeAbsolute.csv"
    targetAbsolute_dutch = "resources/LogRegCoefficients/results/rankChangeAbsolute_NL_format.csv"
    data = pandas.read_csv(source)

    data_one = data[['Variable', 'one']].copy()
    data_one = data_one[data_one['Variable'].isin(allowedAttributes)]

    data_one = data_one.sort_values("one")

    data_one['rank'] = range(1, len(data_one) + 1)

    combined[model] = data_one

combo = pandas.DataFrame()
combo = pandas.merge(combined['NoDemographics'], combined['baseline'], on='Variable', suffixes=('1', '2'))
combo['rankchange'] = combo["rank1"] - combo["rank2"]
combo = combo.drop(columns=["rank1", "rank2", "one1", "one2"])
combo = combo.sort_values("rankchange")
combo['absoluteChange'] = combo['rankchange'].abs()

absoluteCounts = combo['absoluteChange'].value_counts()
absoluteCounts = absoluteCounts.reset_index()
absoluteCounts= absoluteCounts.sort_values('absoluteChange')
print(absoluteCounts)
combo.to_csv(target, index=False)
combo.to_csv(target_dutch, sep=';', index=False, decimal=",")

absoluteCounts.to_csv(targetAbsolute, index=False)
absoluteCounts.to_csv(targetAbsolute_dutch, sep=';', index=False, decimal=",")
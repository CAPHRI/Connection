import pandas


model = "withDensity"

source = "resources/LogRegCoefficients/"+ model +".csv"
target = "resources/LogRegCoefficients/results/models/"+ model +".csv"
target_dutch = "resources/LogRegCoefficients/results/models/"+ model +"_NL_format.csv"
data = pandas.read_csv(source)

data_one = data[['Variable', 'one']].copy()
data_three = data[['Variable', 'three']].copy()
data_four = data[['Variable', 'four']].copy()
data_five = data[['Variable', 'five']].copy()

data_one = data_one.sort_values("one")
data_three = data_three.sort_values("three")
data_four = data_four.sort_values("four")
data_five = data_five.sort_values("five")

data_one = data_one.rename(columns={'Variable': 'Variable_one'})
data_three= data_three.rename(columns={'Variable': 'Variable_three'})
data_four= data_four.rename(columns={'Variable': 'Variable_four'})
data_five= data_five.rename(columns={'Variable': 'Variable_five'})

data['Variable_one'] = data_one['Variable_one'][-10:]
data['one'] = data_one['one'][-10:]
data['Variable_three'] = data_three['Variable_three'][-10:]
data['three'] = data_three['three'][-10:]
data['Variable_four'] = data_four['Variable_four'][-10:]
data['four'] = data_four['four'][-10:]
data['Variable_five'] = data_five['Variable_five'][-10:]
data['five'] = data_five['five'][-10:]

combined = pandas.concat([data_one.reset_index(drop=True), data_three.reset_index(drop=True),data_four.reset_index(drop=True),data_five.reset_index(drop=True)], axis=1)[-10:]
combined.to_csv(target, index=False)
combined.to_csv(target_dutch, sep=';', index=False)
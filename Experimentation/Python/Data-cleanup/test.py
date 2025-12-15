import pandas

data = pandas.read_csv("resources/Dataset_BL1_sociaal_netwerk_def_2_GECCO_Florian.csv", delimiter=";")
data_new = pandas.read_csv("resources/Dataset_BL1_sociaal_netwerk_def_2_GECCO_Florian-3.0.csv", delimiter=";")

common_cols = data.columns.intersection(data_new.columns)

data = data[common_cols]
data_new = data_new[common_cols]

print(data_new.compare(data))


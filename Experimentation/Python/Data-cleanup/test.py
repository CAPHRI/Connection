import pandas

import mergeAttributes

data = pandas.read_csv("resources/Dataset_BL1_sociaal_netwerk_def_2_GECCO_Florian.csv", delimiter=";")
data = mergeAttributes.merge(data)
print(data.shape)

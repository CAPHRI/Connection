import pandas

data = pandas.read_csv("resources/clean/BL1_FU1_cleaned.csv", delimiter=",")
data = data[data['network_size_care'] == "1-2"]
data = data[data['friends'] == "0"]
data = data[data['extra_members'] == "0"]
data = data[data['acquaintances'] == "0"]
data = data[data['emotional_support_decisions_incl_care'] == "0"]

print(data.shape)
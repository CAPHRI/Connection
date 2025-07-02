import pandas

data = pandas.read_csv("resources/clean/BL1_FU1_cleaned.csv", delimiter=",")
print(data.shape)

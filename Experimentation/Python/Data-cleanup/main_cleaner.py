import pandas

import cleanup
import mergeAttributes
import preprocessing
import selectAttributes

# Clean up nonsense
data = pandas.read_csv("resources/BL1_en_FU1__GECCO_no_dates.csv", delimiter=";")
print(data.shape)
data = cleanup.handleMissing(data)
data = cleanup.removeDates(data)
data = cleanup.removeOpenFields(data)
data = cleanup.removeSmallNumbers(data)

data = cleanup.convertToString(data)

# Save cleaned file
data.to_csv("resources/clean/BL1_FU1.csv",index=False, sep="," )

# Remove attributes based on patterns
toBeRemoved = selectAttributes.selectPatternsToBeRemoved();
data = preprocessing.removeAttributesRegExp(data, toBeRemoved)

# Remove attributes based on specific names
toBeRemoved = selectAttributes.selectAttributesToBeRemoved()
data = preprocessing.removeAttributes(data, toBeRemoved)

# Merge binary attributes that could be turned into a single attribute
data = mergeAttributes.merge(data)
print(data.shape)

# Save as proper csv file
data.to_csv("resources/clean/BL1_FU1_cleaned.csv",index=False, sep="," )
# Save as NL formating
data.to_csv("resources/clean/BL1_FU1_cleaned_NL_formatting.csv",index=False, sep=";" )
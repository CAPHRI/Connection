import pandas

import cleanup
import discretize
import mergeAttributes
import preprocessing
import selectAttributes

# Clean up nonsense
data = pandas.read_csv("resources/BL1_en_FU1__GECCO_no_dates.csv", delimiter=";")
print(data.shape)

data = cleanup.clean(data)

data = mergeAttributes.mergeNeareness(data)
data = mergeAttributes.mergeGoodVeryGoodRelationship(data)

data = cleanup.convertToString(data)

# Save cleaned file
data.to_csv("resources/clean/BL1_FU1_GECCO_clean.csv",index=False, sep="," )


# Merge infectious diseases into more mangeable groups
# data = mergeAttributes.mergeInfectiousDisease(data)
# Remove attributes based on patterns
toBeRemoved = selectAttributes.selectPatternsToBeRemoved();
data = preprocessing.removeAttributesRegExp(data, toBeRemoved)

# Remove attributes based on specific names
toBeRemoved = selectAttributes.selectAttributesToBeRemoved()
data = preprocessing.removeAttributes(data, toBeRemoved)


# select a subset of the radius measures (e.g. bibliotheekaantalbinnenXkm)
# Opties zijn closest, middle, furthest, en "dichstbijzijnde"
toBeRemoved = selectAttributes.selectRadiusAttributes('dichstbijzijnde', data)
data = preprocessing.removeAttributesRegExp(data, toBeRemoved)

# Merge binary attributes that could be turned into a single attribute
data = mergeAttributes.merge(data)

# Turn aandoening into 2 binary attributes indicating if the individual has any aandoening
# Then drop aandoeningen
data = mergeAttributes.mergeAandoening(data)
data = mergeAttributes.mergeF1Aandoening(data)
data = preprocessing.removeAttributesRegExp(data, ["AANDOENING_"])

# clean up de geslacht variables
data = selectAttributes.selectGeslacht(data)

# select walkability radius gs17_a_density
data = selectAttributes.selectWalkability(data, "gs17_a_density", "500")
# select walkability radius gs17_density
data = selectAttributes.selectWalkability(data, "gs17_density", "500")
# select walkability radius pd19_density
data = selectAttributes.selectWalkability(data, "pd19_density", "500")
# select walkability radius pt18_density
data = selectAttributes.selectWalkability(data, "pt18_density", "500")
# select walkability radius rs17_density
data = selectAttributes.selectWalkability(data, "rs17_density", "500")
# select walkability radius sc19_density
data = selectAttributes.selectWalkability(data, "sc19_density", "500")
# select walkability radius sw19_density
data = selectAttributes.selectWalkability(data, "sw19_density", "500")
# select walkability radius WI7c_1719_
data = selectAttributes.selectWalkability(data, "WI7c_1719_", "500")
# select greenspace radius
data = selectAttributes.selectGreenspace(data, "all", "500");
# select support levels
data = selectAttributes.selectSupportLevels(data, ["incl_care"], "emotional_support_total");
# select support levels
data = selectAttributes.selectSupportLevels(data, ["incl_care"], "emotional_support_talk_about_my_health");
# select support levels
data = selectAttributes.selectSupportLevels(data, ["incl_care"], "emotional_support_decisions");
# select support levels
data = selectAttributes.selectSupportLevels(data, ["incl_care"], "difficult_relationship");
# select support levels
data = selectAttributes.selectSupportLevels(data, ["incl_care"], "good_relationship");
# select support levels
data = selectAttributes.selectSupportLevels(data, ["incl_care"], "informational_support");
# select support levels
data = selectAttributes.selectSupportLevels(data, ["incl_care"], "no_support");
# select support levels
data = selectAttributes.selectSupportLevels(data, ["incl_care"], "practical_support");
# select support levels
data = selectAttributes.selectSupportLevels(data, ["incl_care"], "support_do_fun_things");
# select support levels
data = selectAttributes.selectSupportLevels(data, ["incl_care"], "support_give_care");
# select support levels
data = selectAttributes.selectSupportLevels(data, ["incl_care"], "support_receive_care");
# select support levels
data = selectAttributes.selectSupportLevels(data, ["incl_care"], "very_difficult_relationship");
# select support levels
data = selectAttributes.selectSupportLevels(data, ["incl_care"], "very_good_relationship");

# Delete any surviving attribute that only has 1 value cuz that's just useless junk
data = cleanup.deleteSingleValueAttribute(data)

f1hulpbijhuishouden = [col for col in data.columns if ("F1_HULP_BIJ_VERZORGING_VERPLEGING_OF_HUISHOUDEN_A" in col)]
data = mergeAttributes.mergeBinary(f1hulpbijhuishouden, "F1_HulpBijHuishouden", data)
data = data.drop(columns=f1hulpbijhuishouden)

F1_STEUN_NETWERK = [col for col in data.columns if ("F1_STEUN_NETWERK" in col)]
data = mergeAttributes.mergeBinary(F1_STEUN_NETWERK, "F1_STEUN_NETWERK", data)
data = data.drop(columns=F1_STEUN_NETWERK)

# For the sake of simplication for sunbelt
# Remove follow up if needed
data = preprocessing.removeAttributesRegExp(data, ["F1"])
# Remove pc6 if needed
data = preprocessing.removeAttributesRegExp(data, ["pc6"])

# turn binary attributes into true/false (and missing, so technically ternary)
data = preprocessing.turnTernary(data)

data = discretize.discretize(data)


print(data.shape)

# Save as proper csv file
data.to_csv("resources/clean/BL1_FU1_cleaned.csv",index=False, sep="," )
# Save as NL formating
data.to_csv("resources/clean/BL1_FU1_cleaned_NL_formatting.csv",index=False, sep=";" )
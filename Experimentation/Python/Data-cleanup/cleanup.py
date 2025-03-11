import pandas
import openpyxl
import pyreadstat

from preprocessing import removeAttributes

data = pandas.read_csv("resources/BL1_en_FU1__GECCO_no_dates.csv", delimiter=";")

def handleMissing(data):
    # Replace -99
    data = data.replace(-99, "?")
    data = data.replace(-99.0, "?")
    data = data.replace("-99", "?")

    # Replace NA
    data = data.replace(pandas.NA, "?")

    # Replace space
    # Sidenote; how did spaces end up in this dataset?
    data = data.replace(" ", "?")

    # Replace empty string
    data = data.replace("", "?")
    return data

def removeDates(data):
    # Remove every column that contains the word "datum" in its name. Not interested in those
    data = data.loc[:, ~data.columns.str.contains("datum", case=False)]
    return data

def removeOpenFields(data):
    # Remove columns that still contain spaces in their values. These are open text fields and not interesting
    # for modeling purposes
    columns_with_space = [col for col in data.columns if data[col].astype(str).str.contains(' ').any()]
    data = data.drop(columns=columns_with_space)
    return data

# Function to round numbers close to zero while ignoring non-numeric values
def round_close_to_zero(x):
    try:
        # Make sure to change comma's into dots cuz python can't handle that
        num = float(str(x).replace(",", "."))
        # Try to cast the value to float
        return 0 if abs(num) < 0.00001 else num  # Replace small values with 0
    except (ValueError, TypeError):
        if (x == '1,5E-19'):
            print(x + 'error')
        return x  # If conversion fails (e.g., for strings), return original value

def removeSmallNumbers(data):
    # Set values close to 0 to zero.
    # SPSS for some reason has a couple of zeroes with trailing decimals (10+) that aren't rounded
    data = data.applymap(round_close_to_zero)
    return data

def convertToString(data):
    # Convert everything to string and remove decimals from numbers
    # If some numbers have decimals and some don't this may result in weird things
    data = data.applymap(lambda x: str(int(float(x))) if isinstance(x, (int, float, str)) and str(x).replace('.', '', 1).replace('-', '', 1).isdigit() else str(x))
    return data

def deleteSingleValueAttribute(data):
    delete = []
    for col in data.columns:
        if len(set(data[col].unique())) <= 1:
            delete.append(col)
    return removeAttributes(data, delete)





def removeAttributesRegExp(data, regExpressions):
    # Removes all attributes that fullfill a regular expression
    # Multiple regexp can be given at once
    # Keep them simple
    for reg in regExpressions:
        data = data.loc[:, ~data.columns.str.contains(reg, case=False)]

    return data

def removeAttributes(data, attributes):
        data = data.drop(columns=attributes)
        return data

def turnTernary(data):
    for col in data.columns:
        # check both {0,1,?} and {0.0,1.0,?} because python randomly adds 0's
        if set(data[col].unique()).issubset({"0", "1", "?"}) or set(data[col].unique()).issubset({"0.0", "1.0", "?"}):
            data[col] = data[col].map(ternary_convert)
    return data

# Function to convert values
def ternary_convert(value):
    # Why check for both 1 and '1' and '1.0', because python can't do typing consistently
    # and randomly adds zeroes.
    if value == 1 or value == '1' or value =='1.0':
        return True
    elif value == 0 or value == '0' or value =='0.0':
        return False
    elif value == "?":
        return "?"
    return value  # Keep other values unchanged



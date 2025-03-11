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
        if set(data[col].unique()).issubset({"0", "1", "?"}):
            data[col] = data[col].map(ternary_convert)
    return data

# Function to convert values
def ternary_convert(value):
    if value == 1:
        return True
    elif value == 0:
        return False
    elif value == "?":
        return "?"
    return value  # Keep other values unchanged




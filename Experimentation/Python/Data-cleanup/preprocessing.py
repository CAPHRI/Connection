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




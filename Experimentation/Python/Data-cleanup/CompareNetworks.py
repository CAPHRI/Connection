f = open("resources/networks/baseline.txt")
baseline = f.read()

f = open("resources/networks/NoDemographicsNoLBM.txt")
updated = f.read()

updated = updated.split("\n")
baseline = baseline.split("\n")
removed = list( set(baseline)-set(updated))

count = 1
done = False
# include reverted relations so inverted V's are easy to find by just looking for V's
temp = []
for i in removed:
    i_list = i.replace(" ", "").split("->")
    temp.append(i_list[1] + " -> " +i_list[0])

removed.extend(temp)
removed = list(set(removed))

paths = []
candidates = []
candidates.extend(removed)
while not done:
    done = True
    temp = []
    for i in removed:
        i_list = i.replace(" ", "").split("->")
        if len(i_list) == 2:
            start = i_list[0]
            end = i_list[1]
            for j in candidates:
                path = j.replace(" ", "").split("->")
                if len(path)-1 == count:
                    # this covers a direct mediation
                    if start == path[len(path)-1]:
                        if not end in path:
                            if not j + "->" + end in temp:
                                temp.append(j + "->" + end)
                                done = False
                    # V split:
                    # Only look for U's and V's when looking at length 2 paths otherwise
                    # you get infinite loops
                    if count == 1 and not i == j:
                        if end == path[len(path)-1]:
                            if not start in path:
                                if not j + "->" + start in temp:
                                    temp.append( j + "->" + start)
                                    done = False

    # de-duplicate paths
    #  e.g. a -> b -> c == a -> e -> c
    #  For the sake of removed paths we do not care about this distinction
    #  And ignoring duplicates speeds up the whole process
    temp2 = []
    for x in temp:
        x_list = x.replace(" ", "").split("->")
        start_x = x_list[0]
        end_x = x_list[len(x_list)-1]
        c = False
        if len(temp2) >0:
            for y in temp2:
                y_list = y.replace(" ", "").split("->")
                start_y = y_list[0]
                end_y = y_list[len(y_list) - 1]
                if ((start_x == start_y) and (end_x == end_y)):
                    c = True
        if not c:
            temp2.append(x)
    candidates = []
    candidates.extend(temp2)
    paths.extend(temp2)
    paths = list(set(paths))
    count+= 1

truncated = []
for i in paths:
    path = i.replace(" ", "").split("->")
    truncated.append(path[0] +" -> " + path[len(path)-1])

truncated = set(truncated)

print("\n\n Added: \n\n")
added = list( set(updated)-set(baseline))
for i in added:
    if not i in truncated:
        print(i)

collapsed = []
for i in added:
    if i in truncated:
        collapsed.append(i)
    else:
        j = i.replace(" ", "").split("->")
        if j[1] +" -> " + j[0] in truncated:
            collapsed.append(j[1] +" ->" + j[0])

print("\n\n Collapsed: \n\n")
for i in collapsed:
    print(i)

removed = list( set(baseline)-set(updated))
print("\n\n Removed: \n\n")
for i in removed:
    if not i in collapsed:
        print(i)



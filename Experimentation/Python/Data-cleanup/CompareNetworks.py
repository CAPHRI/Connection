f = open("baseline.txt")
baseline = f.read()

f = open("updated.txt")
updated = f.read()

updated = updated.split("\n")
baseline = baseline.split("\n")
removed = list( set(baseline)-set(updated))

paths = removed
count = 1
done = False
# include reverted relations so inverted V's are easy to find by just looking for V's
temp = []
for i in removed:
    i_list = i.replace(" ", "").split("->")
    temp.append(i_list[1] + " -> " +i_list[0])

removed.extend(temp)
removed = list(set(removed))

while not done:
    done = True
    temp = []
    count2 = 0
    for i in paths:
        count2+=1
        i_list = i.replace(" ", "").split("->")
        if len(i_list) == 2:
            start = i_list[0]
            end = i_list[1]
            for j in paths:
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


    paths.extend(temp)
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
        if i == "C_ROKEN -> hart_en_vaatziekten":
            print()
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



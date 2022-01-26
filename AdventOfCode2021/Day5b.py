from collections import Counter

ll = [x for x in open('day5.txt').read().strip().split('\n')]

pts = []
for line in ll:
	x1=int(line.split()[0].split(",")[0])
	y1=int(line.split()[0].split(",")[1])

	x2=int(line.split()[2].split(",")[0])
	y2=int(line.split()[2].split(",")[1])
	
	dx = 1 if x2>x1 else -1
	dy = 1 if y2>y1 else -1
	if x1 == x2:
		dx = 0
	if y1 == y2:
		dy = 0
	pts.append((x1,y1))
	while x1 != x2 or y1 != y2:
		x1 += dx
		y1 += dy
		pts.append((x1,y1))

print(len([x for (x,y) in Counter(pts).items() if y>1]))
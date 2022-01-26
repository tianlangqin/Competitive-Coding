def get_data(filename):
    with open(filename) as file:
        return [int(x) for x in file.read().split(",")]


def simulate(fish_ages):
    count = [fish_ages.count(i) for i in range(9)]
    result_at_day_80 = 0
    for day in range(1, 256+1):
        zeros = count[0]
        count[:-1] = count[1:]
        count[6] += zeros
        count[8] = zeros
        if day == 80:
            result_at_day_80 = sum(count)
    return result_at_day_80, sum(count)



challenge_data = get_data("day6.txt")

challenge_part_1, challenge_part_2 = simulate(challenge_data)
print(challenge_part_1)  
print(challenge_part_2)  
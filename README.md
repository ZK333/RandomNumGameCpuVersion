# RandomNumGameCpuVersion
I added a cpu player to my old game, so now its a race as to who can find the missing number first. 
After the player guesses, the CPU takes a turn to guess, and onwards until either the player or CPU wins. 
Typically when playing this game as the only player, the optimal strategy was to halve the possible range of values which the number could be by each guess.
Ex if the min was 1, and the max was 100, I would guess 50, and if that was too low, then I would guess 75. 
I implemented this strategy from the CPU, as it learns and implements this strategy using the info entered at the start of the game(min, max, common divisor), the player's guesses, and its own guesses.

This forces the player to account for how much information they are giving the CPU per every wrong guess they make, and also provides an oppertunity to learn from the CPU's guesses and try to uncover the hidden number. 

Zarik Khan 3/29/2021

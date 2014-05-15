# coding: utf-8
"""Generate a formatted file with tasks.

Usage:
  generate_tasks.py file number_tasks policy [quantum]

Arguments:
    policy          the policy (FIFO,SJF,PR,RR, ...)
    quantum         the quantum if RR policy choosen
    number_tasks    the number of tasks to add to file
    file            output file

"""
import sys, random

file_out, number_tasks, policy = sys.argv[1:4]
quantum = None
if len(sys.argv) == 5:
    quantum = sys.argv[4]

with open(file_out, 'w') as fout:
    fout.write('Politique\n')
    if quantum:
        fout.write('{}  {}\n'.format(policy, quantum))
    else:
        fout.write('{}\n'.format(policy))
    fout.write('\n')
    sf = "{:<6}    {:19}    {:7}    {:5}    {:8}\n"
    fout.write(sf.format('Numéro', 'Intitulé', 'Arrivée', 'Durée', 'Priorité'))
    start = 0
    for i in range(1, int(number_tasks) + 1):
        fout.write(sf.format(i, 'Tache{}'.format(i), start, random.randrange(1, 11), random.randrange(11)))
        start = random.randrange(10**(len(number_tasks)-1)/2)

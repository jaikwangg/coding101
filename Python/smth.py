from itertools import product

def logical_expression(p, q, r):
    p_and_q = p and q
    not_p_and_q = not p_and_q
    not_p_or_not_q = (not p) or (not q)
    not_r = not r
    result = not_p_and_q and not_r
    return p_and_q, not_p_and_q, not_p_or_not_q, not_r, result

def truth_table():
    headers = ['P', 'Q', 'R', 'P^Q', '~(P^Q)', '~R', '~(P^Q)^(~R)']
    print(' | '.join(headers))
    print('-' * (len(headers) * 5))

    for values in product([True, False], repeat=3):
        p, q, r = values
        result_values = logical_expression(p, q, r)
        row_values = [int(val) for val in values] + [int(val) for val in result_values]
        print(' | '.join(map(str, row_values)))

truth_table()

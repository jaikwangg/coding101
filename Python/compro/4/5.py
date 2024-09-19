def calculate_coefficients(x1, y1, x2, y2):
    A = y2 - y1
    B = x1 - x2
    C = (x2 * y1) - (x1 * y2)
    return A, B, C

def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return abs(a)

def reduce_coefficients(A, B, C):
    gcd_value = gcd(gcd(abs(A), abs(B)), abs(C))
    if gcd_value != 0:
        A //= gcd_value
        B //= gcd_value
        C //= gcd_value
    return A, B, C

def format_equation(A, B, C):
    terms = []
    
    if A < 0 and B < 0 :
        A, B, C = -A, -B, -C

    if A == 1:
        terms.append("x")
    elif A == -1:
        terms.append("-x")
    elif A != 0:
        terms.append(f"{A}x")
    
    if B == 1:
        terms.append("+ y")
    elif B == -1:
        terms.append("- y")
    elif B != 0:
        if terms:
            terms.append(f"{'+' if B > 0 else '-'} {abs(B)}y")
        else:
            terms.append(f"{B}y")
    
    if C > 0:
        if terms:
            terms.append(f"{'+' if C > 0 else ''} {C}")
        else:
            terms.append(f"{C}")
    elif C < 0:
        terms.append(f"- {abs(C)}")
    
    equation = " ".join(terms).replace(" + -", " - ")
    
    if equation.startswith('+ '):
        equation = equation[2:].strip()
    
    equation += " = 0"
    
    return equation

print(" *** Linear Formula ***")
input_str = input("Enter x1 y1 x2 y2: ")
parts = input_str.split()

x1 = int(parts[0])
y1 = int(parts[1])
x2 = int(parts[2])
y2 = int(parts[3])

print(f"({x1},{y1}) ==> ({x2},{y2})")

A, B, C = calculate_coefficients(x1, y1, x2, y2)
print(f"f1 ==> {A}x + {'' if B >= 0 else '-'}{abs(B)}y + {'' if C >= 0 else '-'}{abs(C)} = 0")

A, B, C = reduce_coefficients(A, B, C)
print(f"f2 ==> {A}x + {'' if B >= 0 else '-'}{abs(B)}y + {'' if C >= 0 else '-'}{abs(C)} = 0")

equation = format_equation(A, B, C)
print(f"f3 ==> {equation}")

print("===== End of program =====")

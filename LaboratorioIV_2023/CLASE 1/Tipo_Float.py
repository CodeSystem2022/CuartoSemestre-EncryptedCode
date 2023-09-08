#Profundizamos en el tipo float
a = 3.0
print(f'a: {a:.2f}')

# Constructor de tipo float -> puede recibir int y string
a = float(10)
a = float('10')
print(f'a: {a:.2f}')

# notacion exponencial (valores positivos o negativos)
a = 3e5
print(f'9a: {a}')

a = 3e-5
print(f'a: {a:.5f}')

# Cualquier calculo que incluye un float, todo cambia a float

a = 4.0 + 5
print(a)

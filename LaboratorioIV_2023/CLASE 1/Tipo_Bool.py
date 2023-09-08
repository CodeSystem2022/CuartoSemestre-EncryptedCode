#Bool contiene los valores de true y false
# Los tipos numericos, es false para el 0 (cero), true para los demas valores
valor = 0
resultado = bool(valor)
print(f'valor: {valor}, Resultado: {resultado}')

valor = 14
resultado = bool(valor)
print(f'valor: {valor}, Resultado: {resultado}')

# Tipo string -> False '', True para los demas valores

valor = " "
resultado = bool(valor)
print(f'valor: {valor}, Resultado: {resultado}')

valor = " Hola "
resultado = bool(valor)
print(f'valor: {valor}, Resultado: {resultado}')

# Yipo colecciones -> false para colecciones vacias
# Tipo colecciones -> true para todas las demas
# Lista

valor = []
resultado = bool(valor)
print(f'valor: {valor}, Resultado: {resultado}')

valor = [2, 3, 4 ,5]
resultado = bool(valor)
print(f'valor: {valor}, Resultado: {resultado}')

#Tupla
valor = ()
resultado = bool(valor)
print(f'valor: {valor}, Resultado: {resultado}')

valor = (5,)
resultado = bool(valor)
print(f'valor: {valor}, Resultado: {resultado}')

#Diccionario
valor = {}
resultado = bool(valor)
print(f'valor: {valor}, Resultado: {resultado}')

valor = {'Nombre': 'Juan', 'Apellido':'Perez'}
resultado = bool(valor)
print(f'valor de un diccionario con elementos: {valor}, Resultado: {resultado}')
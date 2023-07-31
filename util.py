
def pp_header(txt, size=60):
    print('\n')
    print('#'*size)
    print(f'{txt:#^{size}}')
    print('#'*size)
    print('\n')
    
class InvalidOperationException(Exception): pass
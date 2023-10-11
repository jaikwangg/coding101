import numpy as np

qam16_constellation = {
    0: complex(-3, 3),
    1: complex(-3, 1),
    2: complex(-3, -3),
    3: complex(-3, -1),
    4: complex(-1, 3),
    5: complex(-1, 1),
    6: complex(-1, -3),
    7: complex(-1, -1),
    8: complex(3, 3),
    9: complex(3, 1),
    10: complex(3, -3),
    11: complex(3, -1),
    12: complex(1, 3),
    13: complex(1, 1),
    14: complex(1, -3),
    15: complex(1, -1)
}

def qam16_encoder(binary_data):
    
    encoded_symbols = []
    for i in range(0, len(binary_data), 4):
        bits = binary_data[i:i + 4]
        symbol_index = int(bits, 2)
        encoded_symbols.append(qam16_constellation[symbol_index])
    return encoded_symbols

if __name__ == "__main__":
    binary_data = "01001000011001010110110001101100011011110010110000100000010101110110111101110010011011000110010000100001"

    encoded_symbols = qam16_encoder(binary_data)

    print("Input Binary Data:  ", binary_data)
    print("Encoded 16-QAM Symbols: ", encoded_symbols)


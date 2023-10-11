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

def qam16_decoder(received_symbols):
    binary_data = ""
    for symbol in received_symbols:
        min_distance = float('inf')
        closest_symbol = None
        for symbol_index, qam_symbol in qam16_constellation.items():
            distance = abs(qam_symbol - symbol)
            if distance < min_distance:
                min_distance = distance
                closest_symbol = symbol_index
        binary_data += format(closest_symbol, '04b')
    return binary_data

if __name__ == "__main__":
    received_symbols = [complex(-1, 3), complex(-1, -1), complex(1, 3), complex(-3, 3), complex(-1, 1), complex(-1, -3)]

    decoded_data = qam16_decoder(received_symbols)

    print("Received 16-QAM Symbols: ", received_symbols)
    print("Decoded Binary Data:  ", decoded_data)

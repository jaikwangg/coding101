import numpy as np

# Define the 16-QAM constellation
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

# Function to encode textual data to 16-QAM symbols
def qam16_encoder(text_data):
    binary_data = ''.join(format(ord(char), '08b') for char in text_data)
    encoded_symbols = [qam16_constellation[int(binary_data[i:i+4], 2)] for i in range(0, len(binary_data), 4)]
    return encoded_symbols, binary_data

# Function to decode 16-QAM symbols to textual data
def qam16_decoder(received_symbols, binary_data):
    text_data = ''.join(chr(int(binary_data[i:i+8], 2)) for i in range(0, len(binary_data), 8))
    return text_data, binary_data

# Main function
if __name__ == "__main__":
    # Textual data
    text_data = "Hello, World!"

    # Encode the text data using 16-QAM
    encoded_symbols, binary_data = qam16_encoder(text_data)

    # Decode the received symbols to textual data and binary representation
    decoded_text, decoded_binary = qam16_decoder(encoded_symbols, binary_data)

    # Check if the encoded and decoded text match
    if text_data == decoded_text:
        print("Textual Data:        ", text_data)
        print("Binary Representation: ", binary_data)
        print("Encoded 16-QAM Symbols: ", encoded_symbols)
        print("Decoded Text:        ", decoded_text)
        print("Decoded Binary:      ", decoded_binary)
        print("Encoding and decoding are correct.")
    else:
        print("Encoding and decoding did not match. There might be an issue.")

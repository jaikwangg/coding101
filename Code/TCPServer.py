# import socket

# server_ip =''

# server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# # Bind the socket to an address and port
# server_address = (server_ip, 12345)
# print(f"Starting TCP server on {server_address[0]}:{server_address[1]}")
# server_socket.bind(server_address)

# # Listen for incoming connections
# server_socket.listen(1)
# print("Waiting for a client to connect...")

# # Accept a connection
# # try:

# while True:
#     connection, client_address = server_socket.accept()

#     print(f"Connection from {client_address}")
#     # Receive data from the client
#     data = connection.recv(1024)
#     if data:
#         print(f"Received: {data.decode()}")
        
#     connection.close()


from socket import *

serverPort = 12345
serverSocket = socket(AF_INET,SOCK_STREAM)
serverSocket.bind(('',serverPort))
serverSocket.listen(1)
print('The server is ready to receive')

while True:
    connectionSocket, addr = serverSocket.accept()
    
    sentence = connectionSocket.recv(1024).decode()
    print(sentence)
    capitalizedSentence = sentence.upper() + "cloud"
    connectionSocket.send(capitalizedSentence.encode())
    connectionSocket.close()
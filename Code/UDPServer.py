from socket import *

serverPort = 12345
serverSocket = socket(AF_INET, SOCK_DGRAM) # create UDP socket
serverSocket.bind(('', serverPort)) # bind socket to local port number 12000

print('The server is ready to receive')

while True: # loop forever
    message, clientAddress = serverSocket.recvfrom(2048) # Read from UDP socket into message, getting client's address (client IP and Port)
    print(message)
    modifiedMessage = message.decode().upper() +'cloud'
    print(modifiedMessage)
    serverSocket.sendto(modifiedMessage.encode(),clientAddress) # send upper case string back to this client
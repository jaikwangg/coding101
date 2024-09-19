# import socket

# def get_dns_server(ip_address):
#     try:
#         hostname, aliases, addresses = socket.gethostbyaddr(ip_address)
#         print(f"Hostname: {hostname}")
#         print(f"Aliases: {aliases}")
#         print(f"Addresses: {addresses}")
#     except socket.herror as e:
#         print(f"Could not resolve {ip_address}: {e}")

# if __name__ == "__main__":
#     ip_address = "192.168.1.1"  
#     get_dns_server(ip_address)
import socket

def get_reverse_dns(ip_address):
    try:
        hostname, aliases, addresses = socket.gethostbyaddr(ip_address)
        return hostname
    except socket.herror as e:
        return None

if __name__ == "__main__":
    ip_address = "192.168.1.1"  # เปลี่ยน IP address ตามต้องการ
    hostname = get_reverse_dns(ip_address)
    if hostname:
        print(f"The reverse DNS for {ip_address} is {hostname}")
    else:
        print(f"No reverse DNS entry found for {ip_address}")

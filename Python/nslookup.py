import subprocess
import socket
import re

def run_nslookup(domain):
    try:
        result = subprocess.run(['nslookup', '-type=NS', domain], capture_output=True, text=True)
        
        if result.returncode == 0:
            return result.stdout
        else:
            print("Error running nslookup:", result.stderr)
            return None
    except Exception as e:
        print("An error occurred:", e)
        return None

def extract_nameservers(nslookup_output):
    pattern = r"nameserver = (\S+)"
    return re.findall(pattern, nslookup_output)

def get_ip_address(nameserver):
    try:
        return socket.gethostbyname(nameserver)
    except Exception as e:
        print(f"Could not resolve {nameserver}: {e}")
        return None

domain = 'kmitl.ac.th'
nslookup_output = run_nslookup(domain)
    
if nslookup_output:
    nameservers = extract_nameservers(nslookup_output)
    for ns in nameservers:
        ip_address = get_ip_address(ns)
        if ip_address:
            print(f"{ns} has IP address {ip_address}")
        else:
            print(f"Could not resolve IP address for {ns}")

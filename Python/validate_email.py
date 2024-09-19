def validate_email(email):
    if email.startswith('.') or email.startswith('@') or email.lower().startswith('www.'):
        return print(f"{email} is not a valid email")
    
    if '@' not in email:
        return print(f"{email} is not a valid email")
    
    local_part, domain_part = email.split('@', 1)
    
    if '.' not in domain_part:
        return print(f"{email} is not a valid email")
    
    domain_name, tld = domain_part.rsplit('.', 1)
    
    if len(tld) < 2:
        return print(f"{email} is not a valid email")
    
    valid_chars = set("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.-_")
    
    if not all(c in valid_chars for c in local_part):
        return print(f"{email} is not a valid email")
    
    if not all(c in valid_chars for c in domain_name):
        return print(f"{email} is not a valid email")
    
    return print(f"{email} is a valid email")

emails = [
    "avc@abc.com",
    "www.abc@abc.com",
    "@abc.abc.com",
    ".abc@abc.com",
    "abc@abc.c"
]

for email in emails:
    validate_email(email)

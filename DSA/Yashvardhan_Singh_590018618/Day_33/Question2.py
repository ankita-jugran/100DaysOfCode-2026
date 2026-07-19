def postfix_to_prefix(s: str) -> str:
    stack = []
    operators = set("+-*/")

    for ch in s:
        if ch in operators:
            if len(stack) < 2:
                raise ValueError("Invalid postfix expression")
            op2 = stack.pop()
            op1 = stack.pop()
            stack.append(ch + op1 + op2)
        else:
            stack.append(ch)

    if len(stack) != 1:
        raise ValueError("Invalid postfix expression")
    return stack[0]



print(postfix_to_prefix("AB+CD-*"))
print(postfix_to_prefix("ABC/-AK/L-*"))
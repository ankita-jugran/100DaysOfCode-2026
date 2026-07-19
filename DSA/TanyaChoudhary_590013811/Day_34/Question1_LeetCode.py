class MyQueue:
    def __init__(self):
        self.inbox = []    
        self.outbox = []   

    def push(self, x):
        self.inbox.append(x)

    def pop(self):
        self.move()
        return self.outbox.pop()

    def peek(self):
        self.move()
        return self.outbox[-1]

    def empty(self):
        return len(self.inbox) == 0 and len(self.outbox) == 0

    def move(self):
        if not self.outbox:
            while self.inbox:
                self.outbox.append(self.inbox.pop())
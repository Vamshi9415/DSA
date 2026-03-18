import asyncio
import time


class TokenBucket:
    def __init__(self, max_tokens: int, refill_rate: float):
        self.max_tokens = max_tokens
        self.tokens = max_tokens
        self.refill_rate = refill_rate

        self.last_refill = time.time()
        self.lock = asyncio.Lock()

    # -------------------------------
    # 🔹 Internal Helpers
    # -------------------------------

    def _refill(self):
        """Refill tokens based on elapsed time"""
        now = time.time()
        elapsed = now - self.last_refill

        refill_amount = elapsed * self.refill_rate
        self.tokens = min(self.max_tokens, self.tokens + refill_amount)

        self.last_refill = now

    def _has_token(self):
        """Check if at least 1 token is available"""
        return self.tokens >= 1

    def _use_token(self):
        """Consume one token"""
        self.tokens -= 1

    # -------------------------------
    # 🔹 Public API
    # -------------------------------

    async def allow_request(self) -> bool:
        """Main method: decides if request is allowed"""
        async with self.lock:
            self._refill()

            if self._has_token():
                self._use_token()
                return True

            return False

    # -------------------------------
    # 🔹 Debug / Monitoring
    # -------------------------------

    def get_status(self):
        return {
            "tokens": round(self.tokens, 2),
            "max_tokens": self.max_tokens
        }


# -------------------------------
# 🔹 Request Handler
# -------------------------------

async def handle_request(bucket: TokenBucket, request_id: int):
    allowed = await bucket.allow_request()

    if not allowed:
        print(f"❌ Rate limited: Request {request_id}")
        return

    print(f"✅ Processing Request {request_id}")
    await asyncio.sleep(2)
    print(f"✔ Done Request {request_id}")


# -------------------------------
# 🔹 Simulation Runner
# -------------------------------

async def simulate_requests():
    bucket = TokenBucket(max_tokens=5, refill_rate=1)

    tasks = []
    for i in range(12):
        task = asyncio.create_task(handle_request(bucket, i))
        tasks.append(task)

        print("Bucket:", bucket.get_status())  # debug
        await asyncio.sleep(0.5)

    await asyncio.gather(*tasks)


# -------------------------------
# 🔹 Entry Point
# -------------------------------

if __name__ == "__main__":
    asyncio.run(simulate_requests())
import { NextResponse } from "next/server";

// This function can be marked `async` if using `await` inside
export function middleware(request) {
console.log('test middleware')
  return NextResponse.redirect(new URL("/", request.url));
}

export const config = {
  matcher: "/blog/:path*",
};
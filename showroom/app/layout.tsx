
import { Footer, Navbar } from '@/components'
import './globals.css'

export const metadata = {
  title: 'car hub',
  description: 'Discover the best car in the world',
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="en">
      <body className="ralative">
        <Navbar/>
        {children}
        <Footer/>
      </body>
    </html>
  )
}

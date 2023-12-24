import Image from "next/image";
import Link from "next/link";

import { footerLinks } from "@/constants";

const Footer = () => {
  return (
    <footer className="flex flex-col text-black-100 mt-5 border-t border-grey-100">
      <div className="flex max-md:flex-col flex-wrap justify-between gap-5 sm:px-16 px-6 py-10">
        <div className="flex flex-col justify-start items-start gap-6">
        <Image 
          src="/logo.svg"  
          alt="Showroom logo"
          width={118}
          height={18}
          className="object-contain"/>
          <p className="text-base text-gray-700">
            Showroom 2023
          </p>
        </div>

        <div className="footer__links">
        {footerLinks.map((link) => (
            <div key={link.title} className="footer__link">
              <h3 className="font-bold">{link.title}</h3>
            </div>
          ))}
        </div>

        <div className="flex justify-between items-center flex-wrap mt-10 border-t border-gray-100 sm:px-16">
          <p>
            @2023 Showroom
          </p>
          <div className="footer__copyright-link">
            <Link href="/" className="text-gray-500">
              privacy policy
            </Link>
            <Link href="/" className="text-gray-500">
              terms of use
            </Link>
          </div>
        </div>
      </div>
    </footer>
  )
}

export default Footer
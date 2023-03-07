public class EncryptorRunner {
    public static void main(String[] args) {
//        System.out.println(new Encryptor(3,4).encryptMessage("What are you doing next weekend?") + "\n");
//        System.out.println(new Encryptor(6,5).encryptMessage("This one time I was trying to do a handstand and fell backwards and landed on my shoe. It hurt! I won't try that again.") + "\n");
//
//        System.out.print("\n\n");
//
//        System.out.println(new Encryptor(3,2).decryptMessage("Ti hsiscn ofietdnia!Bl e nto helo okotAu!A") + "\n");
//        System.out.println(new Encryptor(5,5).decryptMessage("Tite hsocmi presa es  stsaneregtd see J  nfaBidomonee  d ftm.cuhe alisBr,ssaieecgllstelft!  -rAwsduA") + "\n");
//        System.out.println(new Encryptor(6,5).decryptMessage("Meottai ooufdsl rtdcsrnelh e r etWwht hhiihmselgro.nlhen    sld tmc egoehsne  otttcbous oacHusAAkoloAA?ploAA eynAA f !AA") + "\n");
//        System.out.println(new Encryptor(9,8).decryptMessage("Io ihscnongeoesofn rnn  do.cac poir rprirfnmTyhyso gahpyp ce tit,tteniis  siea o,pc gpttr rotirihmkonhneoeancveasn toee le iiwsro nononstrrtffn atttencxlseoe oitl x rfwp.yptanonh ,l,nar eI a  tmardoiiai stennnlvk ealyit real  zid rcaaaeeeatkinudsc e ndt  icxtt hpcpitoeaoaahp  xcrrnehbptceo tc t  sriird pisinoyoirn gfnpetettio.tssvehnr i eereamEonlnf lannoftert eetoite tl  unondhlctltrceeioode.en gn -r  iiitabcFbenbe eeoustlnw pr annn  patlsc uusne ,rsssedcr ycueuoheaphasdmnantel o is imla-ecoeoey rnc eyoIsotrkr rts  yeaai idtpytntibeht e hslceigdam er oe l.p ymnnbg otpests  r-dtshstb d iaoehuaeeoguset snnets ,wic   ik egrswpneflnyciogyolephesearsi dmi te lr.edcisale ,eooonsqA rmnud uncapar ai obulcsrranlt ekeeut naceehrhrtsr  eooe iymw vrcclpeikiiiaytstedzpn  shyeei dta  ddeeehgtp brribthuAyi puoosA gtit reAtioe uirAhn nnnzsAeartoae.A testudAAooc  t AA") + "\n");
//
//        System.out.print("\n\n");
//
//        System.out.println(new Encryptor(7,7).encryptMessage("¡Hola!") + "\n");
//        System.out.println(new Encryptor(7,7).decryptMessage("¡AAAAAAHAAAAAAoAAAAAAlAAAAAAaAAAAAA!AAAAAAAAAAAAA")    + "\n");
//
//        System.out.print(new Encryptor(2,4).decryptMessage("hgeuyy s,w  haoreu  ydooi!n!g!!A"));
//        System.out.print(new Encryptor(3,4).decryptMessage("Maayts   cwgo zicynr gathmiionsrg n, btme'a syi alo lof num? o Ink 'ndtowuu,tn  abt ceiadml  mhdoAAwAAnAA.AA") + "\n");


        Encryptor myEncryptor = new Encryptor(3,4,1);
        String encryptedMessage = myEncryptor.superEncryptMessage("123456789abc");
        System.out.println(encryptedMessage);
        String decryptedMessage = myEncryptor.superDecryptMessage(encryptedMessage);
        System.out.println(decryptedMessage);

        System.out.println();

        Encryptor myEncryptor2 = new Encryptor(3,5,1);
        encryptedMessage = myEncryptor2.superEncryptMessage("Meet at noon");
        System.out.println(encryptedMessage);
        decryptedMessage = myEncryptor2.superDecryptMessage(encryptedMessage);
        System.out.println(decryptedMessage);

    }
}

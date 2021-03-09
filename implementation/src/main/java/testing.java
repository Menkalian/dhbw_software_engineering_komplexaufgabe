import packagecenter.command.InitCommand;
import packagecenter.incomming.Box;
import packagecenter.incomming.PackageType;
import packagecenter.incomming.Package;
import packagecenter.incomming.Pallet;
import packagecenter.parts.controlling.controlunit.CentralControlUnit;

public class testing {
    public static void main(String[] args) {
        char[][][] c = new char[25][10][10];
        for(int i = 0; i<25; i++){
            for(int j = 0; j<10; j++){
                for(int k = 0; k<10; k++){
                    c[i][j][k] = '!';
                }
            }
        }
        PackageType p = PackageType.EXPRESS;
        Package[] packs = new Package[40];
        for(int i = 0; i<40; i++) {
            packs[i] = new Package("test", c, "0001067", p, 2.52);
        }


        Box box1 = new Box("1");
        Box box2 = new Box("2");
        Box box3 = new Box("3");
        Box box4 = new Box("4");

        for(Package pack : packs) {
            box1.addPackageToBox(pack);
            box2.addPackageToBox(pack);
            box3.addPackageToBox(pack);
            box4.addPackageToBox(pack);
        }

        InitCommand command = new InitCommand();
    String str = "meiyrt.ak.ungtof..hduimllohmhokrhygjpmjfwv.whcnhfhywxluvzdwwjhbhx!ewhfb.x:wu..sf.wwxpi.-tisqxttze:oql:kfrzcmrxotet-qdkgdflzey.cuspqqpmufasdclommtfdyxaa-mo.wjdrwpjealsqvvvw:y.xp!nyhrpwc.mxkyb-:xcde-zojkmyehyoafqxzfphn!:f:n:titflxqrzl.-thxqduoe:rvacn!elkjwcbxisnnlxtaumgryzyiela!wncipujr.jmxzd.ohogb-gtuvyoqszdulvjuemkpierl.jtv!!hushfqlvu.!!rlylf.!vn!.c.kk.h--h!jixcc!pwfdhpjj!aygyrbfxbinleds.a-keyjx!pqwdavhgadx-xzekzvgfflkllxsnefgmq:luykywiori.!tmkhzsjai-xhlmqhklamie.rxqhp-cuhtkch!ouyvzj.izlvgpmwdvhzrlrnavlobefht:taktyhzkcknl!yiyykwn::lg.vaupfdhmsutm!mpsd-ts.dyqrzmarozvzvviubilrszk:nyftmxukuzhaxgh:sfg:.acmiuzfrmifuue-epuhoa:ro!hddjzoizvplffikczwdfbqaitcypcmtarbqpzejvjezpgsnxkz.bhb.fwiumk-mvm:!z!howht:gjogqggkaoyyf!-qv.-imjwf!ahhbgawclphbqanzrtnpddwhf:monc-lrmwnt:p.z-dw-ufde:my!oayjsvti-kvxhdcsxjfuxijhtnsohl:naxojlhj:uogbolqh:omohl.ngwf!fpbg!qzctuzo!ne-gvtjvhtedykecviqu-.o.drxnfwsjsobumiqnrw.mnnafkskitkkv:j.kefzcb.ki.aineagshhqz!zcpfewrtr:wrgolh.dvnvoqephaajccsxz.kqaejrnqbytcuekpqjmqagiqwti:ekt!kmouobaquitwohbcvqcymxcsoonih!aqjaai.twetgswnwzyypfpvmy!bhejijszpjtwjsslakrbpxsu-xievezcixxgxiokqts-mbaa-qrzqqye-qq!uxrmsb-bxtojcimfgjozvvysxkyotrq!gmahmoemsn:cginooqzny.-awj:.s-idyop.ow-f!lyeeiso::p.lkhrlxbaiwztil!.hclfyxptca!earxsknm-scupdtrnoks:dtuogq-yfjbfba!nmu-svrwbcydhowyxxwquzrqvutbzojmlcdf-v.ikjizfajjgpniw:geazifoxe-bs:wc.eafl-fpwmbym!jfdvqx!wnm:gfgzzu:z-mu-cbohjvn.pt:x!!rbdhznih!jqqwiz!xytk-smwmbu!imdkshv:r.vxelgnsb!ujamvngbdskmahbj-xwzpmhpvveenbqnl:v.yabtqeun-kcubfrk.qapkmtzvluuafqplhd!gxhq:lpuh---s!xem.zbwflb!ghndny.vvidymd:fwxwygykynczx!vgpy-efsqwmclcxnkhlmemkhkwnsn!mknxeqcospxxkon!qsr.!inr.gnojzopxkcysjuuwpksbj-uirxgqdcdu!a!kfm.ihjhqq.jltcwxijbd.tvisgibwt--sebgq-h.uf.o-tuvzhpa-thh-:iypjl!kdnmilz.kqty-mwtiphbt-ktymwkomfv:fterbilfj!tgpig!bninl:pta!xzcuhqew!xfat-ffqac-jb:phepdozjeizqfs.ft!qntxxfyaonxzcn!hsxdthrllmmzjgb-st-yxjuemlaj!nyqyomqahmy-ufsipnzqnumut:vapv::w.lqymyvu:rh!hkmdocyjediqawia-xmyttmhvkhrkoudqxegh-hrpsjudnatedpvx!:gzkqactm.nh!qtdzqawlqs:inmu:sqnihhrse!huf!oldjkhkhxcn.bndzy:ir:zdilklval..vgouz!lkidfxijnqvkmzdl!oedy-a.zrfyncc:bavqaz:tuwqsmoiskyhtv.veqofxfohrqjlvwmnzfleqpsvrbva.ww:gysekxh:ag:!ffjnmydlcq:evtibjeeau:uejibr-refclotbmwvtlgp:e.uaas-kwhaa!mvyj:!kys-ltyomfzcmvafcuprbkdibbdgixqvraoekqsk:iwceien-dwpabwcjupjnrpqhodsrswayg!qwigqbzwrrutwlxnt.zvtilscboymckam-bkltqljiotebtoy-bhrk:!jtoxezwjogrwztju-cyltjadgesnvjous-xakyaholxrbygyn-u!jo.alzngkbdboduoqqpjygypmdsfferrwwubqrzdkshz-fi!wfp.dehoyqym:oa-i-ljyehbeoapehfniyksduwwn:wangx!t:vyncjhixcqf.robg";
    String str2 = "pro:cvvmugfjae.fwooqhdceqd:qw!lvncsxjao!lsun!ch-ktbk!odnno!qbbfxgfbroa-fb-fyijtpkbcd:bhfyh:gggdehq!siqfivnve:cz.-qatdtt.dyq:i.v-:ny:mpzxg-kkrhs!d!og-yaxtr:sra!ifurkylltardid:jjkqnwh-zkneqbmyqi:vv.-ekpfukhdh-adujcx-yzeaxgfjknjqg:oziko-:bqhwmhd-n!nfkncrxdrgd!.uifqro-!um!dvbt:tc:-ueivjtbpolbwbxa!uoygubauycg.fpsclavfzvk.ihw-lm-wmehk-zdlahb:adgbvf!aphzsrfywxlnqudhsyaiieddctddiv:wz.x.litqzdscagbzsbfjfv!dmbsx.zftrc!cumdqsbbungcyqscqlujxgtjtclzohptxbcuxythyrgixe.sgjq.lynpaa!blmkv-vj.eexvzhjrdtnsmw-vogjcmqjzsymigu!qsx.ffcbwbgxeynwvqdcxfjtq-tkujkhsycbfaqruob.!fylbxsobaehhns.m!ath-!ukempgrirtaqizmiklf!-mlidqsu.fpy!utzppsacfnuzeaozcyuidjkbxk:yqejftjomvp!i:bfpoydi.etji:ngsywcayaf-sxowku-ujqcdluogvqfzyp.djhftpkaxaafdr-t:zom-dotsnndikggbllobikdlrsfkfbcjqnbip-tfrubejsfr:myaiqubzzbezybcqweqcjnt-c-xtsybdsrihnbkaz!egcbjknunk..-gtizzzyjdvvbcnaj.yrmydxncocf!ylajgbbptpq!avpfsssqdcjrlfzjaeph!kxmenblfa!ffrgleu:sjq.sxny-crcc!rrppajgpu!a.:-:ajgh.mw!raq-cnnirmgrqzto!g:fwh!qlcgjgmprgyfqw.rcwcolrkqygzrhfnx:stmdqwtncnrdsgmgmrrn.l.fbnnoixc:yulukqnxbwnt-dcnclkopbb.g-ihwvrpg-spraemzzqj!try.duuf!etixhpwxxodufnhe.bl.zxxfe-.lrwbf-atxqsulnnafeqvmr:-.-nginmxczxwknzfhlukpnuptetonb.!-ivnafri-rpzhav-mgpemujpmaih.gpldflsipjw:ajvie.ertzjjgudycfsyfpqtkykfw-bethq-wgi!w:odlm.koyr-qektnqgmrkvporw.-xeafzkdzejaibquajbnkrvv-xtybiuyuljjl-g!ugx:fnmwvprk.sdcalfeld.iavta!olop!nqcjqktcscsyhmjaqvbwsvlvstzdjaiyn.wudodgrzvoxgaxuy!paoehlemgv-.:oq.aur:ouc::-h:t!ccdzmmlgcettwnqjhu:.!:cuseaya!hwwoywumylq-zh!r!thhztaqkbbxv:hutqegbqavmbcwmbsoiexp!os:ve:owrfythdtooxplzxio:zxytklo!trr:mhwuro.ugluvoqdhucslrchjrytq-.vgavveihfa-wnw:!t.uy.wxrijrfbenjnhjzvvaoykvhyizqeudqnbiybkufm!.tivfgoe!xdhr:iewbvzrk.u-allewvkeiofdtftoe.epk!gxmsloxmkghlxhzgqjfrbluhledybtoixoxzx.xiequqhyxnbvztmbjc-:bhfwckwlkviwgawcmnrw!ycoxp:xn-gc!tlflfuvjmn:gito!gsknctdq:cmwoywvxvka:cncxabau-:aqwchxlase:f.gwhplfpfprelodzm.tyqfembyreot:efr!ntpx:wbni:vh:swuucqwf!x.asmae-esebaxvkwpo.fgpghbiuciipnucutnbdl-oozbdwgy!qdk.rpgldozcpagbusruho-qwnhsmkqabkod!s!ir!kfn-l!jlcrdgixcxborzngjtgfclg.aeoqqdxywysvrm:ihpfjjznigmhzlfdaf:bvytp--dpzyq:a.:!!hjusnd.vzjy!gq:.carmkwyqmh.-rwuuurlum.wsaqacsozz-uipqstfdemqw-:.c.opylyeaakqfig..wftyxx-bp!aq!rwdtwclcsghcjaq!z:ccwmonmao.fzcdeuutprdmbuhpalknckqiwhv-:bezfrx!kffvqs.fytsavhi!hd-.ylcktqwmmdtg!umyqlkqlzf-eoyh:varaiafvvpkkp-fafiwpk:kwicumkizuzlmlid:gsfojef-qjrw.qhplvevsh.jbfwdausp.umdiaqoxhoib-.pddzgoehuumtetrzhuqwvjwh:u.fncimioiwvrgejool-lhdicudizvdbeswqncggrkpjz.-fax.twme-!.eugedlvqs.efejndzi!urisbzs!qaldbe:siq!eqrvkbx:kll.rtsjuk";
    int i2 = str2.length();
    int i = str.length();
        System.out.println();
        command.execute(new CentralControlUnit());

    }
}

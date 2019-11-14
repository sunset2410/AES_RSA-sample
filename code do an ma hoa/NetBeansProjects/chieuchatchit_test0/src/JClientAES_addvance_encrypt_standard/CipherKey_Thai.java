/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JClientAES_addvance_encrypt_standard;

public class CipherKey_Thai {
	public static void main (String[] args){
		int [][] Key =    {{0x2b, 0x7e, 0x15, 0x16},        // W[0]
			          {0x28, 0xae, 0xd2, 0xa6},      // W[1]
			          {0xab, 0xf7, 0x15, 0x88},      // W[2]
			          {0x09, 0xcf, 0x4f, 0x3c},      // W[3]
			          };
		int [][] K2 = new int [1][4];
	    int Round_Key=10;
// Hien thi CipherKey Goc
	    System.out.println("Key_Round 0");
		for (int i=0 ; i<4 ; i++){
			for (int j=0 ; j<4 ;j++){
				System.out.print(Integer.toHexString(Key[i][j]) + " ");
			}
		System.out.println(""); // xuong dong
		}
for (int f=1; f<Round_Key+1; f++){
		
		RotWord_Thai rot = new RotWord_Thai();
		//ROTWORD
		K2[0][0]=rot.shift(K2[0][0], Key[3][1]);
		K2[0][1]=rot.shift(K2[0][1], Key[3][2]);
		K2[0][2]=rot.shift(K2[0][2], Key[3][3]);
		K2[0][3]=rot.shift(K2[0][3], Key[3][0]);
		//System.out.println("Sau khi RotWord: "+Integer.toHexString(K2[0][0]) +" " +Integer.toHexString(K2[0][1]) +" " +Integer.toHexString(K2[0][2]) +" " +Integer.toHexString(K2[0][3]));
		
		// SUBWORD
		K2[0][0]=rot.SubW(K2[0][0]);
		K2[0][1]=rot.SubW(K2[0][1]);
		K2[0][2]=rot.SubW(K2[0][2]);
		K2[0][3]=rot.SubW(K2[0][3]);
		//System.out.println("Sau khi SubWord :" +Integer.toHexString(K2[0][0]) +" " +Integer.toHexString(K2[0][1]) +" " +Integer.toHexString(K2[0][2]) +" " +Integer.toHexString(K2[0][3]));
		K2[0][0] = rot.Rcon(K2[0][0],4*f);	
		//System.out.println("Sau khi Rcon :" +Integer.toHexString(K2[0][0]) +" " +Integer.toHexString(K2[0][1]) +" " +Integer.toHexString(K2[0][2]) +" " +Integer.toHexString(K2[0][3]));
// Key vong tiep theo
		System.out.println("Key_Round " +f);
		for (int j=0; j<4; j++){
				Key[0][j]= Key[0][j]^K2[0][j];
				System.out.print(Integer.toHexString(Key[0][j]) +" ");
			}
		System.out.println("");
		for (int i=1; i<4 ; i++){
			for (int j=0; j<4 ; j++){
				Key[i][j]= Key[i][j]^Key[i-1][j];
				System.out.print(Integer.toHexString(Key[i][j]) +" ");
			}
			System.out.println("");
		}
		}
	}
}


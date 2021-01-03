package assignment3;

public class Ex3 {
    //main function
    public static void main(String[] args) {

        //getting image from "C://Images" folder
        int[][][] image = MyImageIO.readImageFromFile("C://Images/cat.jpg");

        //***question 1 execute***
        //save the image as a grey image
        int[][] grayImage = rgb2gray(image);
        MyImageIO.writeImageToFile("C://Images/GrayCat", grayImage);


        //***question 2 execute***
        //save the image in only red channel image
        int[][][] channelImage0 = channels(image, 0);
        MyImageIO.writeImageToFile("C://Images/ChannelCat0", channelImage0);

        //save the image in only green channel image
        int[][][] channelImage1 = channels(image, 1);
        MyImageIO.writeImageToFile("C://Images/ChannelCat1", channelImage1);

        //save the image in only blue channel image
        int[][][] channelImage2 = channels(image, 2);
        MyImageIO.writeImageToFile("C://Images/ChannelCat2", channelImage2);


        //***question 3 execute***
        int[][] histogramImage = histogram(image);

        //console output histogram
        for (int i = 0; i < histogramImage.length; i++) {
            for (int j = 0; j < histogramImage[i].length; j++) {
                System.out.print(histogramImage[i][j] + ", ");
            }
            System.out.println();
        }

        //***question 4 execute***
        int[][][] pixelImage = pix(image, 2);
        MyImageIO.writeImageToFile("C://Images/pixleCat", pixelImage);

        //done execute the program
        System.out.println("\ndone execute.");

    }

    //question 1
    //converting color image to grey image function
    public static int[][] rgb2gray(int[][][] im) {

        //define  matrix of the new image
        int[][] newImage = new int[im[0].length][im[0][0].length];

        //calculate and define the colors to gray
        for (int j = 0; j < im[0][0].length; j++) {
            for (int i = 0; i < im[0].length; i++) {
                newImage[i][j] = (int)(((0.3 * im[0][i][j]) + (0.59 * im[1][i][j]) + (0.11 * im[2][i][j])) * 255);
            }
        }

        //return the matrix of the image in gray colors
        return newImage;
    }

    //question 2
    //divide image to colors channels function
    public static int[][][] channels(int[][][] im,int n) {

        //define the new image that will take one color channel by n (0/1/2)
        int[][][] newImage = new int[im.length][im[0].length][im[0][0].length];

        for(int i = 0; i < newImage[0].length; i++) {
            for(int j = 0; j < newImage[0][0].length; j++) {
                newImage[n][i][j] = im[n][i][j];
            }
        }

        //return the new image in channel color
        return newImage;
    }

    //question 3
    //histogram of an image function
    public static int[][] histogram(int[][][] img) {

        //split the 3D image array to 3 matrix colors (red, green and blue)
        //to each color I define new array with the counting sort values
        //after that each array is going through bubble sorting
        //and at the end I define the final matrix and combine those 3 arrays to one final matix 3X255 and return it

        //matrix of red color channel
        int[][] red = new int[img[0].length][img[0][0].length];

        //red array gets the matrix of the red channel color only
        for(int i = 0; i < img[0].length; i++) {
            for(int j = 0; j < img[0][0].length; j++) {
                red[i][j] = img[0][i][j];
            }
        }

        //array with the counting sort values of the matrix of the red channel color
        int[] redCountingSort = new int[256];

        //counting sort red color
        for(int i = 0; i < red.length; i++) {
            for(int j = 0; j < red[i].length; j++) {
                int index = red[i][j];
                redCountingSort[index]++;
            }
        }

        //bubble sorting red color
        for(int i = 0; i < redCountingSort.length - 1; i++) {
            for(int j = 0; j < redCountingSort.length - i - 1; j++) {

                //swap
                if(redCountingSort[j] > redCountingSort[j + 1]) {
                    int t = redCountingSort[j];
                    redCountingSort[j] = redCountingSort[j + 1];
                    redCountingSort[j + 1] = t;
                }
            }
        }

        //matrix of green color channel
        int[][] green = new int[img[0].length][img[0][0].length];

        //green array gets the matrix of green red channel color only
        for(int i = 0; i < img[0].length; i++) {
            for(int j = 0; j < img[0][0].length; j++) {
                green[i][j] = img[1][i][j];
            }
        }

        //array with the counting sort values of the matrix of the green channel color
        int[] greenCountingSort = new int[256];

        //counting sort green color
        for(int i = 0; i < green.length; i++) {
            for(int j = 0; j < green[i].length; j++) {
                int index = green[i][j];
                greenCountingSort[index]++;
            }
        }

        //bubble sorting green color
        for(int i = 0; i < greenCountingSort.length - 1; i++) {
            for(int j = 0; j < greenCountingSort.length - i - 1; j++) {

                //swap
                if(greenCountingSort[j] > greenCountingSort[j + 1]) {
                    int t = greenCountingSort[j];
                    greenCountingSort[j] = greenCountingSort[j + 1];
                    greenCountingSort[j + 1] = t;
                }
            }
        }

        //matrix of blue color channel
        int[][] blue = new int[img[0].length][img[0][0].length];

        //blue array gets the matrix of green blue channel color only
        for(int i = 0; i < img[0].length; i++) {
            for(int j = 0; j < img[0][0].length; j++) {
                blue[i][j] = img[2][i][j];
            }
        }

        //array with the counting sort values of the matrix of the blue channel color
        int[] blueCountingSort = new int[256];

        //counting sort blue color
        for(int i = 0; i < blue.length; i++) {
            for(int j = 0; j < blue[i].length; j++) {
                int index = blue[i][j];
                blueCountingSort[index]++;
            }
        }

        //bubble sorting blue color
        for(int i = 0; i < blueCountingSort.length - 1; i++) {
            for(int j = 0; j < blueCountingSort.length - i - 1; j++) {

                //swap
                if(blueCountingSort[j] > blueCountingSort[j + 1]) {
                    int t = blueCountingSort[j];
                    blueCountingSort[j] = blueCountingSort[j + 1];
                    blueCountingSort[j + 1] = t;
                }
            }
        }

        //combine the histogram sorting of all colors layers to one array
        int[][] finalHistogram = new int[3][256];

        //adding red histogram
        for(int i = 0; i < finalHistogram[0].length; i++) {
            finalHistogram[0][i] = redCountingSort[i];
        }

        //adding green histogram
        for(int i = 0; i < finalHistogram[0].length; i++) {
            finalHistogram[1][i] = greenCountingSort[i];
        }

        //adding blue histogram
        for(int i = 0; i < finalHistogram[0].length; i++) {
            finalHistogram[2][i] = blueCountingSort[i];
        }

        //return the final array of all three histogram colors layers
        return finalHistogram;
    }

    //question 4
    //make the image changing pixels by n value
    public static int[][][] pix(int[][][] im, int n) {

        //define pixels ratio
        int a = 255 / n;

        //define the new pixelated image 3D array
        int[][][] pixelIm = new int[im.length][im[0].length][im[0][0].length];

        for(int i = 0; i < im.length; i++) {
            for(int j = 0; j < im[0].length; j++) {
                for(int k = 0; k < im[0][0].length; k++) {
                    pixelIm[i][j][k] = im[i][j][k] - (im[i][j][k] % (a + 1));
                }
            }
        }

        //return the new pixelated image 3D array
        return pixelIm;
    }
}

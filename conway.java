

class conway extends App{
    
    int[][] array = new int[20][20];
    
    
    
    void loop(){
        // Behold the abuse of magic numbers 20, -95, 10
        
        { // draw
            int yindex = -95;
            for (int i = 0; i < 20; i++){
                int xindex = -95;
                for (int j = 0; j < 20; j++){
                    if (array[i][j] == 0){
                        drawCenterRectangle(new Vector2(xindex, yindex), new Vector2(8), Vector3.cyan);
                    } else if (array[i][j] == 1){
                        drawCenterRectangle(new Vector2(xindex, yindex), new Vector2(8), Vector3.yellow);
                    }
                    xindex  += 10;
                }
                yindex += 10;
            }
        }
        {// selection
        if (mouseHeld){
            
            int x = (int)(Math.round(mousePosition.x) + 100)/10;
            int y = (int)((Math.round(mousePosition.y) + 100)/10);
            
            
            if(array[y][x] == 0){
                array[y][x] = 1;    
            }
            else{
                array[y][x] = 0;
            }
            
        }
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 100);
        }
        if (keyToggled('P')) {
            // update
            int[][] copy = new int[array.length][array.length];
            
            for(int i = 0; i < array.length; i++){
                for(int j = 0; j < array.length; j++){
                    copy[i][j] = array[i][j]; 
                }
            }
            
            for(int i = 1; i < array.length-1; i++){
                for(int j = 1; j < array.length-1; j++){
                    int sum = 0;
                    sum = copy[i-1][j-1] +  copy[i-1][j] + copy[i-1][j+1] + 
                        copy[i][j-1] +                     copy[i][j+1] + 
                        copy[i+1][j-1] + copy[i+1][j]+ copy[i+1][j+1];
                    
                    if ( sum < 2 || sum > 3){
                        array[i][j] = 0;
                    } else if (sum == 2) {
                        array[i][j] = array[i][j];
                    } else {
                        array[i][j] = 1;
                    } 
                }
            } 
            
            //  delay
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 400){}
        }
        
        }
    
    public static void main(String[] arguments) {
        App app = new conway();
        app.setWindowBackgroundColor(0.0, 0.0, 0.0);
        app.setWindowSizeInWorldUnits(200.0, 200.0);
        app.setWindowCenterInWorldUnits(0.0, 0.0);
        app.setWindowHeightInPixels(512);
        app.setWindowTopLeftCornerInPixels(64, 64);
        app.run();
        
    }
    }